package feature.stdlib

import util.chaining._

object StringExt212 extends App {

    println("\n========== StringExt 2.12")

    implicit class StringOps(private val s: String) {
        import scala.util.Try
        def toIntOption: Option[Int] = Try(s.toInt).toOption
        def toDoubleOption: Option[Double] = Try(s.toDouble).toOption
        def toBooleanOption: Option[Boolean] = Try(s.toBoolean).toOption
    }

    "----- String#toIntOption" tap println
    val i1 = "42".toInt tap println
    val iOpt1 = "42".toIntOption tap println
    val iOpt2 = "x42".toIntOption tap println

    "\n----- String#toDoubleOption" tap println
    val d1 = "42.0".toDouble tap println
    val dOpt1 = "42.0".toDoubleOption tap println
    val dOpt2 = "42.x".toDoubleOption tap println

    "\n----- String#toDoubleOption" tap println
    val b1 = "true".toBoolean tap println
    val bOpt1 = "true".toBooleanOption tap println
    val bOpt2 = "false".toBooleanOption tap println
    val bOpt3 = "no".toBooleanOption tap println

    println("==========\n")
}
