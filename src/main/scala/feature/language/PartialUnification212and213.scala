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

    Compile / scalacOptions ++= {
      val sv = (Compile / scalaVersion).value
      println(s"\n>>>>>          compiling for Scala $sv\n")
      if (sv.startsWith("2.13"))
        Seq.empty
      else
        Seq(
          "-Ypartial-unification", // (removed in scala 2.13) allow the compiler to unify type constructors of different arities
          "-language:higherKinds"  // (not required since scala 2.13.1) suppress warnings when using higher kinded types
        )
 */

object PartialUnification212and213 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Partial Unification 2.13")

  """----- Scala 2.13: partial-unification is already enabled ---""" tap println
  """----- Scala 2.12: scalacOptions += "-Ypartial-unification" ---""" tap println

  import feature.stdlib.Using212and213._

  lines("src/main/scala/feature/language/PartialUnification212and213.scala")
    .slice(30, 56) foreach println

  def foo[F[_], A](fa: F[A]): String =
    fa.toString

  val either: Either[String, Int] = Right(42).withLeft[String]
  foo(either)

  val intToInt: Function1[Int, Int] = x => x * 2
  foo(intToInt)

  prtLine()
}
