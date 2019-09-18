package jsonencoder213

sealed trait Json
case class JsonObject(fields: List[(String, Json)]) extends Json
case class JsonArray(items: List[Json]) extends Json
case class JsonString(value: String) extends Json
case class JsonNumber(value: Double) extends Json
case class JsonBoolean(value: Boolean) extends Json
case object JsonNull extends Json
