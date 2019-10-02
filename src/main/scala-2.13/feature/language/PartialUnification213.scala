package feature.language

// import scala.language.higherKinds // redundant since 2.13.1

/*
  Scala 2.13: partial-unification is already enabled

  See:
  https://github.com/scala/scala/pull/5102
  https://gist.github.com/djspiewak/7a81a395c461fd3a09a6941d4cd040f2
 */
import util._

object PartialUnification213 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Partial Unification 2.13")

  println("----- Scala 2.13: partial-unification is already enabled ---")
  import feature.stdlib.Using213._
  lines("src/main/scala-2.13/feature/language/PartialUnification213.scala")
    .slice(18, 28) foreach println

  def foo[F[_], A](fa: F[A]): String =
    fa.toString

  val either: Either[String, Int] = Right(42).withLeft[String]
  foo(either)

  val intToInt: Function1[Int, Int] = x => x * 2
  foo(intToInt)

  prtLine()
}
