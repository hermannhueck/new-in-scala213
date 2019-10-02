package feature.language

import scala.util.chaining._

import util._

object SymbolLiterals213 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Symbol Literals deprecated in 2.13")

  val symbol1 = 'symbol1 // deprecated
  symbol1 tap println

  val symbol2 = Symbol("symbol2") // new: create symbol with Symbol.apply
  symbol2 tap println

  prtLine()
}
