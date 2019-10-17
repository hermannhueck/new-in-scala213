package feature.stdlib

import scala.util.chaining._
import compat213.either._

import util._

object Either212 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Either 2.12")

  "Either#flatten is available in 2.13, not in 2.12, but provided by compat213.either" tap println
  println

  val rr = Right(Right(42))
  rr tap (x => println(s"rr: $x"))
  rr.flatten tap (x => println(s"rr flattened: $x"))
  println

  val rl = Right(Left("Error RL"))
  rl tap (x => println(s"rl: $x"))
  rl.flatten tap (x => println(s"rl flattened: $x"))
  println

  val l = Left("Error L")
  l tap (x => println(s"l: $x"))
  l.flatten tap (x => println(s"l flattened: $x"))
  println

  val ll = Left(Left("Error LL"))
  ll tap (x => println(s"ll: $x"))
  ll.flatten tap (x => println(s"ll flattened: $x"))
  ll.swap.flatten tap (x => println(s"ll swapped & flattened: $x"))
  println

  prtLine()
}
