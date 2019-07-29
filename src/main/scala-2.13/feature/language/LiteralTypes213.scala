package feature.language;

import scala.util.chaining._

object LiteralTypes213 extends App {

  println("\n========== Literal Types 2.13")

  val wahr: true = true
  wahr tap println

  val foo: "foo" = "foo"
  foo tap println

  val one: 1 = 1
  one tap println

  val other_one: one.type = one
  other_one tap println
  implicitly[other_one.type =:= 1]

  valueOf[42] tap println // is the same as ...
  new scala.ValueOf(42).value tap println

  println("==========\n")
}
