package jsonencoder213

trait JsonEncoder[A] {
  def encode(a: A): Json
}

object JsonEncoder {

  def apply[A](implicit encoder: JsonEncoder[A]): JsonEncoder[A] = encoder

  def createEncoder[A](f: A => Json): JsonEncoder[A] =
    new JsonEncoder[A] {
      def encode(a: A): Json = f(a)
    }

  implicit val stringEncoder: JsonEncoder[String]   = createEncoder(JsonString(_))
  implicit val doubleEncoder: JsonEncoder[Double]   = createEncoder(JsonNumber(_))
  implicit val floatEncoder: JsonEncoder[Float]     = createEncoder(JsonNumber(_))
  implicit val intEncoder: JsonEncoder[Int]         = createEncoder(JsonNumber(_))
  implicit val longEncoder: JsonEncoder[Long]       = createEncoder(JsonNumber(_))
  implicit val booleanEncoder: JsonEncoder[Boolean] = createEncoder(JsonBoolean(_))

  implicit def optionEncoder[A](implicit encoder: JsonEncoder[A]): JsonEncoder[Option[A]] =
    createEncoder(opt => opt.map(encoder.encode).getOrElse(JsonNull))

  implicit def listEncoder[A](implicit encoder: JsonEncoder[A]): JsonEncoder[List[A]] =
    createEncoder(list => JsonArray(list.map(encoder.encode)))

  trait JsonObjectEncoder[A] extends JsonEncoder[A] {
    def encode(value: A): JsonObject
  }

  def createObjectEncoder[A](f: A => JsonObject): JsonObjectEncoder[A] =
    new JsonObjectEncoder[A] {
      def encode(value: A): JsonObject = f(value)
    }

  implicit val productEncoder: JsonObjectEncoder[Product] =
    createObjectEncoder(encodeProduct)

  object ops {

    implicit class JsonOps1[A](private val a: A) extends AnyVal {
      def toJson(implicit encoder: JsonEncoder[A]) = encoder.encode(a)
    }
    implicit class JsonOps2[A](private val optA: Option[A]) extends AnyVal {
      def toJson(implicit encoder: JsonEncoder[Option[A]]) = encoder.encode(optA)
    }
    implicit class JsonOps3(private val p: Product) extends AnyVal {
      def toJson(implicit encoder: JsonEncoder[Product]) = encoder.encode(p)
    }
  }

  import ops._

  def encodeProduct(p: Product): JsonObject = {

    val fields: List[(String, Json)] = (0 until p.productArity).toList map { index =>
      val name: String = p.productElementName(index)
      val value: Any   = p.productElement(index)
      // (name, value) tap println
      val jsonValue = value match {
        case b: Boolean => b.toJson
        case s: String  => s.toJson
        case d: Double  => d.toJson
        case f: Float   => f.toJson
        case i: Int     => i.toJson
        case l: Long    => l.toJson
        // case opt @ Option(_) => opt.toJson
        case _ => throw new Exception("element not encodable")
      }
      name -> jsonValue
    }

    JsonObject(fields)
  }
}
