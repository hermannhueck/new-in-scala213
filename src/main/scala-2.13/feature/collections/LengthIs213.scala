package feature.collections

import scala.util.chaining._

object LengthIs213 extends App {

    println("\n========== Coll#lengthIs 2.13")

    val xs = List.fill(5000)(scala.util.Random.nextInt)

    if (xs.lengthIs > 100) { // lenghtIs or sizeIs traverses no more than 101 element
        new IllegalArgumentException("Too many elements!") tap println
    } else {
        s"The list has ${xs.length} elements." tap println
    }

    println("==========\n")
}
