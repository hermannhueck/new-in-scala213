package feature.stdlib;

import scala.util.chaining._

object Either213 extends App {

    println("\n========== Either 2.13")

    val nestedEither = Right(Right(5))
    nestedEither tap (x => println(s"nested: $x"))
    nestedEither.flatten tap (x => println(s"flattened: $x"))
    "Either#flatten is available in 2.13" tap println

    println("==========\n")
}
