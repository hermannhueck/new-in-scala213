package feature.stdlib

import scala.util.chaining._
import compat213.string._

import util.formatting._

object StringOps212and213 extends util.App {

  printTextInLine("StringOps 2.12 and 2.13")

  "----- String#toIntOption" pipe println
  val i1    = "42".toInt pipe println
  val iOpt1 = "42".toIntOption pipe println
  val iOpt2 = "x42".toIntOption pipe println

  "\n----- String#toDoubleOption" pipe println
  val d1    = "42.0".toDouble pipe println
  val dOpt1 = "42.0".toDoubleOption pipe println
  val dOpt2 = "42.x".toDoubleOption pipe println

  "\n----- String#toDoubleOption" pipe println
  val b1    = "true".toBoolean pipe println
  val bOpt1 = "true".toBooleanOption pipe println
  val bOpt2 = "false".toBooleanOption pipe println
  val bOpt3 = "no".toBooleanOption pipe println
}
