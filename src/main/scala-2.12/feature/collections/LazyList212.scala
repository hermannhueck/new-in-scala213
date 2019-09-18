package feature.collections

import compat213.chaining._

import util._

object LazyList212 extends App {

  prtSubTitleObjectName(this)

  prtSubTitle("Stream/LazyList 2.12")

  // Stream is lazy in it's tail, but eager in it's head

  val stream: Stream[(Int, Int)] =
    Stream
      .continually(42)
      .take(10)
      .zipWithIndex
      .map { case (value, index) => (index, value) } tap println

  stream.to[List] tap println

  prtLine()
}
