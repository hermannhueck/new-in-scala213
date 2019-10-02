package feature.collections

import scala.util.chaining._

import util._

object LazyList213 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Stream/LazyList 2.13")

  // Stream is lazy in it's tail, but eager in it's head
  // LazyList is lazy in it's head and tail

  val stream: Stream[(Int, Int)] = // Stream deprecated in 2.13
    Stream
      .continually(42)
      .take(10)
      .zipWithIndex
      .map { case (value, index) => (index, value) } tap println

  stream.to(List) tap println

  val ll: LazyList[(Int, Int)] =
    LazyList
      .continually(42)
      .take(10)
      .zipWithIndex
      .map { case (value, index) => (index, value) } tap println

  ll.to(List) tap println

  prtLine()
}
