package feature.stdlib

import compat213.chaining._
import compat213.either._

import util._

object Either212 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Either 2.12")

  "Either#flatten is available in 2.13, not in 2.12, but provided by compat213.either" tap println
  println

  val rr = Right(Right(42))
  println(s"rr: $rr")
  println(s"rr flattened: ${rr.flatten}")
  println

  val rl = Right(Left("Error RL"))
  println(s"rl: $rl")
  println(s"rl flattened: ${rl.flatten}")
  println

  val l = Left("Error L")
  println(s"l: $l")
  println(s"l flattened: ${l.flatten}")
  println

  prtLine()
}
