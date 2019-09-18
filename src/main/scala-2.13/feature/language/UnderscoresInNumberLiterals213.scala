package feature.language;

import scala.util.chaining._

import util._

object UnderscoresInNumberLiterals213 extends App {

  prtSubTitleObjectName(this)

  prtSubTitle("Underscores in Number Literals 2.13")

  val int0: Int = 1000000 tap println
  val int1: Int = 1_000_000 tap println
  val int2: Int = 1_0_0_0_0_0_0 tap println
  // val int3: Int = 1_0_0_0_0_0_0_ tap println // compile error: trailing separator is not allowed

  val long: Long     = 1_000_000_000L tap println
  val float: Float   = 1_000.99f tap println
  val double: Double = 1_000_000.999_999 tap println

  prtLine()
}
