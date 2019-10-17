package feature.language

import scala.util.chaining._

import util.formatting._

object SymbolLiterals212 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Symbol Literals 2.12")

  val symbol1 = 'symbol1 // deprecated in 2.12
  symbol1 tap println

  val symbol2 = Symbol("symbol2") // new: create symbol with Symbol.apply
  symbol2 tap println

  prtLine()
}
