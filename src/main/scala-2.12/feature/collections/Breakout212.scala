package feature.collections

import scala.util.chaining._

import util.formatting._

object Breakout212 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Breakout 2.12")

  // example taken from
  // https://stackoverflow.com/questions/1715681/scala-2-8-breakout

  val list                      = List(1, 2, 3) tap println
  val toPair: Int => (Int, Int) = x => x -> x
  println

  // With breakOut the return type is implicitly chosen by the compiler to best match the expected type.
  // Depending on how you declare the receiving variable, you get different results.

  val indexedSeq                 = list.map(toPair)(collection.breakOut)
  val array: Array[(Int, Int)]   = list.map(toPair)(collection.breakOut)
  val stream: Stream[(Int, Int)] = list.map(toPair)(collection.breakOut)
  val seq: Seq[(Int, Int)]       = list.map(toPair)(collection.breakOut)
  val set: Set[(Int, Int)]       = list.map(toPair)(collection.breakOut)
  val map: Map[Int, Int]         = list.map(toPair)(collection.breakOut)

  ">>> default target type: IndexedSeq" pipe println; println(indexedSeq)
  ">>> target type: Array[Int, Int]" pipe println; println(array)
  ">>> target type: Stream[Int, Int]" pipe println; println(stream)
  ">>> target type: Seq[Int, Int]" pipe println; println(seq)
  ">>> target type: Set[Int, Int]" pipe println; println(set)
  ">>> target type: Map[Int, Int]" pipe println; println(map)

  prtLine()
}
