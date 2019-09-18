package feature.stdlib

import compat213.chaining._

object Either212 extends App {

  println("\n========== Either 2.12")

  val nestedEither = Right(Right(5))
  nestedEither tap (x => println(s"nested: $x"))
  nestedEither.flatMap(x => x) tap (x => println(s"flatMapped with identity: $x"))
  "Either#flatten is not available in 2.12" tap println

  println("==========\n")
}
