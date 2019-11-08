package feature.language;

import scala.util.chaining._

import util.formatting._

object LiteralTypes213 extends util.App {

  printTextInLine("Literal Types 2.13")

  val wahr: true = true
  wahr pipe println

  val foo: "foo" = "foo"
  foo pipe println

  val one: 1 = 1
  one pipe println

  val other_one: one.type = one
  other_one pipe println
  implicitly[other_one.type =:= 1]

  val x1: Int = valueOf[42] tap println // is the same as ...
  val x2: Int = new scala.ValueOf(42).value tap println
}
