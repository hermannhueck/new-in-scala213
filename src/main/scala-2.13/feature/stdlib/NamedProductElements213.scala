package feature.stdlib

import scala.util.chaining._

object NamedProductElements213 extends App {

  println("\n========== Named Product Elements 2.13")

  sealed trait Gender extends Product with Serializable
  case object Male    extends Gender
  case object Female  extends Gender

  case class Person(name: String, age: Int, gender: Gender, email: String) {
    def tupled: (String, Int, Gender, String) = Person.unapply(this).get
  }

  val johndoe = Person("John Doe", 42, Male, "john@doe.com")

  johndoe.productElementNames foreach println // since 2.13

  println
  johndoe.productElementName(0) tap (name => print(s"$name: ")) // since 2.13
  johndoe.productElement(0) tap println                         // before 2.13
  johndoe.productElementName(1) tap (name => print(s"$name: ")) // since 2.13
  johndoe.productElement(1) tap println                         // before 2.13

  println

  def elementNameAndValue(p: Person, index: Int): String =
    s"${p.productElementName(index)}: ${p.productElement(index)}"

  (0 until johndoe.productArity).toList foreach { index =>
    elementNameAndValue(johndoe, index) tap println
  }

  println

  def pairToJson(name: String, value: Any): String =
    s"""{ "$name": $value }"""

  def productElementToJson(p: Product, index: Int): String =
    pairToJson(p.productElementName(index), p.productElement(index))

  def productToJson(product: Product): String =
    (0 until product.productArity).toList
      .map { index =>
        productElementToJson(product, index)
      }
      .mkString("{ ", ", ", " }")

  implicit class ProductOps(private val product: Product) {
    def toJsonString: String = productToJson(product)
  }

  johndoe.toJsonString tap println
  // { { "name": John Doe }, { "age": 42 }, { "gender": Male }, { "email": john@doe.com } }
  johndoe.tupled.toJsonString tap println
  //{ { "_1": John Doe }, { "_2": 42 }, { "_3": Male }, { "_4": john@doe.com } }

  println("==========\n")
}
