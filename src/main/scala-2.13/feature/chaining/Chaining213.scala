package feature.chaining

object Chaining213 extends App {

    println("\n========== Chaining 2.13")

    import scala.util.chaining._

    val x: Int = 5 tap println

    val y: Int = 5 pipe (_ * x) tap println

    List(1, 2, 3) tap (ys => println("debug: " + ys.toString))

    val times6 = (_: Int) * 6
    (1 - 2 - 3) pipe times6 pipe scala.math.abs tap println

    val doAll = times6 andThen scala.math.abs
    doAll(1 - 2 - 3) tap println

    println("==========\n")
}