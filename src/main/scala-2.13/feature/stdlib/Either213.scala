package feature.stdlib;

import scala.util.chaining._

import util._

object Either213 extends App {

  prtSubTitleObjectName(this)

  prtSubTitle("Either 2.13")

  "Either#flatten is available in 2.13" tap println
  println

  val rightRight = Right(Right(5))
  rightRight tap (x => println(s"rightRight: $x"))
  rightRight.flatten tap (x => println(s"rightRight flattened: $x"))
  println

  val rightLeft = Right(Left("Error"))
  rightLeft tap (x => println(s"rightLeft: $x"))
  rightLeft.flatten tap (x => println(s"rightLeft flattened: $x"))
  println

  val left = Left("Error")
  left tap (x => println(s"left: $x"))
  left.flatten tap (x => println(s"left flattened: $x"))
  println

  prtLine()
}
