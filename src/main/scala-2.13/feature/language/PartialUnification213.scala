package feature.language

import scala.language.higherKinds

/*
  Scala 2.13: partial-unification is already enabled

  See:
  https://github.com/scala/scala/pull/5102
  https://gist.github.com/djspiewak/7a81a395c461fd3a09a6941d4cd040f2
 */
object PartialUnification213 extends App {

  println("\n========== Partial Unification 2.12")

  println("----- Scala 2.13: partial-unification is already enabled ---")
  import feature.stdlib.Using213._
  lines("src/main/scala-2.13/feature/language/PartialUnification213.scala") drop 18 take 6 foreach println

  def foo[F[_], A](fa: F[A]): String =
    fa.toString

  foo { x: Int => x * 2 }

  println("==========\n")
}
