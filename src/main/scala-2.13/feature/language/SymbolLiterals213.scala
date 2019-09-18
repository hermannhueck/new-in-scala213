package feature.language

import scala.util.chaining._

object SymbolLiterals213 extends App {

  println("\n========== Symbol Literals deprecated in 2.13")

  val symbol1 = 'symbol1 // deprecated
  symbol1 tap println

  val symbol2 = Symbol("symbol2") // new: create symbol with Symbol.apply
  symbol2 tap println

  println("==========\n")
}
