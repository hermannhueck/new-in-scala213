package feature.stdlib

import compat213.chaining._
import compat213.either._

import util._

object Either212 extends App {

  prtSubTitleObjectName(this)

  prtSubTitle("Either 2.12")

  "Either#flatten is available in 2.13, not in 2.12, but provided by compat213.either" tap println
  println

  val rightRight = Right(Right(5))
  println(s"rightRight: $rightRight")
  println(s"rightRight flattened: ${rightRight.flatten}")
  println

  val rightLeft = Right(Left("Error"))
  println(s"rightLeft: $rightLeft")
  println(s"rightLeft flattened: ${rightLeft.flatten}")
  println

  val left = Left("Error")
  println(s"left: $left")
  println(s"left flattened: ${left.flatten}")
  println

  prtLine()
}
