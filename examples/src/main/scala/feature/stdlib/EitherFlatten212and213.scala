package feature.stdlib

import scala.util.chaining._
import compat213.either._

import util.formatting._

object EitherFlatten212and213 extends util.App {

  printTextInLine("Either#flatten 2.12 and 2.13")

  "Either#flatten is available in 2.13, not in 2.12, but provided by compat213.either" pipe println
  println

  val rr = Right(Right(42))
  rr pipe (x => println(s"rr: $x"))
  rr.flatten pipe (x => println(s"rr flattened: $x"))
  println

  val rl = Right(Left("Error RL"))
  rl pipe (x => println(s"rl: $x"))
  rl.flatten pipe (x => println(s"rl flattened: $x"))
  println

  val l = Left("Error L")
  l pipe (x => println(s"l: $x"))
  l.flatten pipe (x => println(s"l flattened: $x"))
  println

  val ll = Left(Left("Error LL"))
  ll pipe (x => println(s"ll: $x"))
  ll.flatten pipe (x => println(s"ll flattened: $x"))
  ll.swap.flatten pipe (x => println(s"ll swapped & flattened: $x"))
  println
}
