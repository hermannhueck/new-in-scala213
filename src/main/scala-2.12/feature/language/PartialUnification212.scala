package feature.language

import scala.language.higherKinds

import compat213.either._

/*
  Scala 2.12: code compiles only with -Ypartial-unification enabled

  See:
  https://github.com/scala/scala/pull/5102
  https://gist.github.com/djspiewak/7a81a395c461fd3a09a6941d4cd040f2
 */
import util.formatting._

object PartialUnification212 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Partial Unification 2.12")

  println("----- Scala 2.12: code compiles only with -Ypartial-unification enabled ---")
  import feature.stdlib.Using212._
  lines("src/main/scala-2.12/feature/language/PartialUnification212.scala")
    .slice(19, 29) foreach println

  def foo[F[_], A](fa: F[A]): String =
    fa.toString

  val either: Either[String, Int] = Right(42).withLeft[String]
  foo(either)

  val intToInt: Function1[Int, Int] = x => x * 2
  foo(intToInt)

  prtLine()
}
