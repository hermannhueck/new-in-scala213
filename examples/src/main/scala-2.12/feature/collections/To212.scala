package feature.collections

import scala.util.chaining._

import util.formatting._

object To212 extends util.App {

  printTextInLine("Coll#to 2.12")

  val map = Map("one" -> 1, "two" -> 2, "three" -> 3)

  val l1 = map.toList pipe println
  val l2 = map.to[List] pipe println

  import scala.collection.compat._
  val l3 = map.to(List) pipe println // not available in 2.12 std lib but in compat lib
}
