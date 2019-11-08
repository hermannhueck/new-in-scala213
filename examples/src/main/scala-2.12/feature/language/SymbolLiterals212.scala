package feature.language

import scala.util.chaining._

import util.formatting._

object SymbolLiterals212and213 extends util.App {

  printTextInLine("Symbol Literals allowed in 2.12, deprecated in 2.13")

  val symbol1 = 'symbol1 // literal deprecated in 2.13
  symbol1 pipe println

  val symbol2 = Symbol("symbol2") // new: create symbol with Symbol.apply
  symbol2 pipe println
}
