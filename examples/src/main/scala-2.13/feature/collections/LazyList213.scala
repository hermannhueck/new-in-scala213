package feature.collections

import scala.util.chaining._

import util.formatting._

object LazyList213 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Stream/LazyList 2.13")

  // Stream is lazy in it's tail, but eager in it's head
  // LazyList is lazy in it's head and tail

  // Stream is deprecated in 2.13
  /*
    val stream: Stream[(Int, Int)] =
      Stream
        .continually(42)
        .take(10)
        .zipWithIndex
        .map { case value -> index => index -> value } pipe println

    stream.to(List) pipe println
   */

  val ll: LazyList[(Int, Int)] =
    LazyList
      .continually(42)
      .take(10)
      .zipWithIndex
      .map { case value -> index => index -> value } tap println

  ll.to(List) pipe println

  prtLine()
}
