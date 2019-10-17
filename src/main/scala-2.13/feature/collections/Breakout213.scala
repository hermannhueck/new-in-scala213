package feature.collections

import scala.util.chaining._

import util.formatting._

object Breakout213 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Breakout 2.13")

  // example taken from
  // https://stackoverflow.com/questions/1715681/scala-2-8-breakout

  val list                      = List(1, 2, 3) tap println
  val toPair: Int => (Int, Int) = x => x -> x
  println

  // In 2.13 we use the to method to convert the mapped iterator into the target collection.

  val list2                      = list.iterator.map(toPair)
  val array: Array[(Int, Int)]   = list.iterator.map(toPair).to(Array)
  val stream: Stream[(Int, Int)] = list.iterator.map(toPair).to(Stream)
  val seq: Seq[(Int, Int)]       = list.iterator.map(toPair).to(Seq)
  val set: Set[(Int, Int)]       = list.iterator.map(toPair).to(Set)
  val map: Map[Int, Int]         = list.iterator.map(toPair).to(Map)

  ">>> target type: List" tap println; println(list2)
  ">>> target type: Array[Int, Int]" tap println; println(array)
  ">>> target type: Stream[Int, Int]" tap println; println(stream)
  ">>> target type: Seq[Int, Int]" tap println; println(seq)
  ">>> target type: Set[Int, Int]" tap println; println(set)
  ">>> target type: Map[Int, Int]" tap println; println(map)

  prtLine()
}
