package feature.collections

import compat213.chaining._

import util._

object MapView212 extends App {

  prtSubTitleObjectName(this)

  prtSubTitle("MapView 2.12")

  val kvs: Map[String, Int] = Map("one" -> 1, "two" -> 2, "three" -> 3) tap println

  val kvsFlipped
      : Map[Int, String] = kvs.toList.map { case (fst, snd) => (snd, fst) }.toMap tap println

  "\n>>> Map#mapValues returns Map in 2.12:" tap println
  // def mapValues[W](f: (V) ⇒ W): Map[K, W]
  // Map#mapValues returns Map in 2.12
  val mappedValues: Map[String, Int] = kvs.mapValues(_ + 10) tap println

  "\n>>> Map#filterKeys returns Map in 2.12:" tap println
  // def filterKeys(p: (K) ⇒ Boolean): Map[K, V]
  // Map#filterKeys returns Map in 2.12
  val keysFiltered: Map[Int, String] = kvsFlipped.filterKeys(_ % 2 != 0) tap println

  prtLine()
}
