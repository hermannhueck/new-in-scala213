package feature.stdlib;

import scala.util.chaining._

import util._

object StringOps213 extends App {

  prtSubTitleObjectName(this)

  prtSubTitle("StringOps 2.13")

  "----- String#toIntOption" tap println
  val i1    = "42".toInt tap println
  val iOpt1 = "42".toIntOption tap println
  val iOpt2 = "x42".toIntOption tap println

  "\n----- String#toDoubleOption" tap println
  val d1    = "42.0".toDouble tap println
  val dOpt1 = "42.0".toDoubleOption tap println
  val dOpt2 = "42.x".toDoubleOption tap println

  "\n----- String#toDoubleOption" tap println
  val b1    = "true".toBoolean tap println
  val bOpt1 = "true".toBooleanOption tap println
  val bOpt2 = "false".toBooleanOption tap println
  val bOpt3 = "no".toBooleanOption tap println

  prtLine()
}
