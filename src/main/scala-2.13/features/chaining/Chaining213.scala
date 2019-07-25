package features.chaining

object Chaining213 extends App {

    println("\n========== Chaining 2.13")

    import scala.util.chaining._

    val x: Int = 5 tap println

    val y: Int = 5 pipe (_ * x) tap println

    println("==========\n")
}