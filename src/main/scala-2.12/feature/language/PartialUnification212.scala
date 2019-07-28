package feature.language

import util.either._
import scala.language.higherKinds

/*
  Scala 2.12: code compiles only with -Ypartial-unification enabled

  See:
  https://github.com/scala/scala/pull/5102
  https://gist.github.com/djspiewak/7a81a395c461fd3a09a6941d4cd040f2
 */
object PartialUnification212 extends App {

  println("\n========== Partial Unification 2.12")

  println("----- Scala 2.12: code compiles only with -Ypartial-unification enabled ---")

  def foo[F[_], A](fa: F[A]): String =
    fa.toString

  val either: Either[String, Int] = Right(42).withLeft[String]
  foo { either }

  val intToInt: Function1[Int, Int] = x => x * 2
  foo { intToInt }

  println("==========\n")
}
