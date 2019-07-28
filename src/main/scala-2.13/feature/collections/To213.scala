package feature.collections

import scala.util.chaining._

object To213 extends App {

    println("\n========== Coll#to 2.13")

    val map = Map("one" -> 1, "two" -> 2, "three" -> 3)

    val l1 = map.toList tap println
    // val l2 = map.to[List] tap println // not available in 2.13
    val l3 = map.to(List) tap println

    println("==========\n")
}