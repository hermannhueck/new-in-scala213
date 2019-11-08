package feature.collections

import scala.util.chaining._

import util.formatting._

object LengthIs212 extends util.App {

  printTextInLine("Coll#lengthIs 2.12")

  val xs = List.fill(5000)(scala.util.Random.nextInt)

  if (xs.length > 100) { // traverses all elements of the list in order to compute the length
    new IllegalArgumentException("Too many elements!") pipe println
  } else {
    s"The list has ${xs.length} elements." pipe println
  }
}
