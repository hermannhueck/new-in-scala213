package feature.stdlib

import util.formatting._

object Chaining212and213 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Chaining 2.12 + 2.13")

  println(s"${dash(10)} without chaining ${dash(10)}")

  {
    val x: Int = 5
    println(x)

    val y: Int = 5 * x
    println(y)

    val z = Some(5).map(_ * x).map(v => { println(v); v })
    println(z.get)
  }

  println(s"${dash(10)} with chaining ${dash(10)}")

  {
    import scala.util.chaining._

    "In 2.13 chaining is provided by scala.util.chaining in the scala standard lib." tap println
    "In 2.12 chaining is provided by scala.util.chaining in my user lib.\n" tap println

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
