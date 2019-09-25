package feature.stdlib;

import scala.util.chaining._

import util._

object Either213 extends App {

  prtSubTitleObjectName(this)

  prtSubTitle("Either 2.13")

  "Either#flatten is available in 2.13" tap println
  println

  val rr = Right(Right(42))
  rr tap (x => println(s"rr: $x"))
  rr.flatten tap (x => println(s"rr flattened: $x"))
  println

  val rl = Right(Left("ErrorRL"))
  rl tap (x => println(s"rl: $x"))
  rl.flatten tap (x => println(s"rl flattened: $x"))
  println

  val l = Left("ErrorL")
  l tap (x => println(s"l: $x"))
  l.flatten tap (x => println(s"l flattened: $x"))
  println

  prtLine()
}
