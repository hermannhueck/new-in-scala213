package feature.collections

import scala.util.chaining._

import util.formatting._

object MapView212 extends App {

  prtTitleObjectName(this)

  prtSubTitle("MapView 2.12")

  val kvs: Map[String, Int] = Map("one" -> 1, "two" -> 2, "three" -> 3) tap println

  def flip[A, B](t: (A, B)): (B, A) = t match { case (fst, snd) => (snd, fst) }
  val kvsFlipped: Map[Int, String]  = kvs.toList.map(flip).toMap tap println

  "\n>>> Map#mapValues returns Map in 2.12:" pipe println
  // def mapValues[W](f: (V) ⇒ W): Map[K, W]
  // Map#mapValues returns Map in 2.12
  val mappedValues: Map[String, Int] = kvs.mapValues(_ + 10) tap println

  "\n>>> Map#filterKeys returns Map in 2.12:" pipe println
  // def filterKeys(p: (K) ⇒ Boolean): Map[K, V]
  // Map#filterKeys returns Map in 2.12
  val keysFiltered: Map[Int, String] = kvsFlipped.filterKeys(_ % 2 != 0) tap println

  prtLine()
}
