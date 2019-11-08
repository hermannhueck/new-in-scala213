package feature.language

/*
  Scala 2.13: partial-unification is already enabled

  See:
  https://github.com/scala/scala/pull/5102
  https://gist.github.com/djspiewak/7a81a395c461fd3a09a6941d4cd040f2
 */

// import scala.language.higherKinds // redundant since 2.13.1

import scala.util.chaining._
import compat213.either._
import util.formatting._

/*
  see scalacOptions in build.sbt:

  scalacOptions ++= {
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, n)) if n >= 13 =>
        Seq.empty
      case _ =>
        Seq(
          "-Ypartial-unification", // (removed in scala 2.13) allow the compiler to unify type constructors of different arities
          "-language:higherKinds", // (not required since scala 2.13.1) suppress warnings when using higher kinded types
        )
    }
  }

 */

object PartialUnification212and213 extends util.App {

  printTextInLine("Partial Unification 2.13")

  """----- Scala 2.13: partial-unification is already enabled ---""" pipe println
  """----- Scala 2.12: scalacOptions += "-Ypartial-unification" ---\n""" pipe println

  import feature.stdlib.Using212and213._

  val file = "src/main/scala/feature/language/PartialUnification212and213.scala"
  printFileContent(file, 33, 66)

  def foo[F[_], A](fa: F[A]): String =
    fa.toString

  val either: Either[String, Int] = Right(42).withLeft[String]
  foo(either)

  val intToInt: Function1[Int, Int] = x => x * 2
  foo(intToInt)

  printLine()

  def printFileContent(file: String, fromIncl: Int, toIncl: Int): Unit =
    lines(file)
      .zipWithIndex
      .map { case (line, index) => (index + 1, line) }
      .map { case (no, line) => s"$no    $line" }
      .slice(fromIncl - 1, toIncl)
      .foreach(println)
}
