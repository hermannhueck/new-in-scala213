package feature.collections

import util.chaining._

object MapView212 extends App {

    println("\n========== MapView 2.12")

    val kvs: Map[String, Int] = Map("one" -> 1, "two" -> 2, "three" -> 3) tap println
    val kvsFlipped: Map[Int, String] = kvs.toList.map { case (fst, snd) => (snd, fst) }.toMap tap println

    ">>> mapValues:" tap println
    val mappedValues: Map[String, Int] = kvs.mapValues(_ + 10) tap println

    ">>> filterKeys:" tap println
    val keysFiltered: Map[Int, String] = kvsFlipped.filterKeys(_ %2 != 0) tap println

    println("==========\n")
}
