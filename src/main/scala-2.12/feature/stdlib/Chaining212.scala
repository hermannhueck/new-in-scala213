package feature.stdlib

import util.formatting._

object Chaining212 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Chaining 2.12")

  {
    val x: Int = 5
    println(x)

    val y: Int = 5 * x
    println(y)

    val z = Some(5).map(_ * x).map(v => { println(v); v })
    println(z.get)
  }

  println("-----")

  {
    import scala.util.chaining._

    val x: Int = 5 tap println

    5 pipe (_ * x) tap println

    List(1, 2, 3) tap (ys => println("debug: " + ys.toString))

    val times6 = (_: Int) * 6
    (1 - 2 - 3) pipe times6 pipe scala.math.abs tap println

    val doAll = times6 andThen scala.math.abs
    doAll(1 - 2 - 3) tap println
  }

  prtLine()
}
