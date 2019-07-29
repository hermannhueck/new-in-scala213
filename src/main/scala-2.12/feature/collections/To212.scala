package feature.collections

import util.chaining._

object To212 extends App {

    println("\n========== Coll#to 2.12")

    val map = Map("one" -> 1, "two" -> 2, "three" -> 3)

    val l1 = map.toList tap println
    val l2 = map.to[List] tap println

    import scala.collection.compat._
    val l3 = map.to(List) tap println // not available in 2.12 std lib but in compat lib

    println("==========\n")
}
