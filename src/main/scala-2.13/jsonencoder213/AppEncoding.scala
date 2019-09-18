package jsonencoder213

import scala.util.chaining._
import util._

object AppEncoding extends App {

  import JsonEncoder.ops._

  prtLine()

  true.toJson tap println
  false.toJson tap println
  "Foo".toJson tap println
  42.0.toJson tap println
  42.0f.toJson tap println
  42.toJson tap println
  42L.toJson tap println

  println
  Some(42).toJson tap println
  Option.empty[Int].toJson tap println

  println
  List(1, 2, 3).toJson tap println
  List("baz", "bar", "baz").toJson tap println

  println
  Person("John Doe", 42, false, "john@doe.com").toJson tap println

  prtLine()
}
