package feature.collections

import compat213.chaining._

import util._

object LengthIs212 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Coll#lengthIs 2.12")

  val xs = List.fill(5000)(scala.util.Random.nextInt)

  if (xs.length > 100) { // traverses all elements of the list in order to compute the length
    new IllegalArgumentException("Too many elements!") tap println
  } else {
    s"The list has ${xs.length} elements." tap println
  }

  prtLine()
}
