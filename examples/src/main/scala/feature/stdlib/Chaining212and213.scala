package feature.stdlib

import util.formatting._

object Chaining212and213 extends util.App {

  printTextInLine("Chaining 2.12 + 2.13")

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

    "In 2.13 chaining is provided by scala.util.chaining in the scala standard lib." pipe println
    "In 2.12 chaining is provided by scala.util.chaining in my user lib.\n" pipe println

    val x: Int = 5 tap println

    5 pipe (_ * x) pipe println

    List(1, 2, 3) pipe (ys => println("debug: " + ys.toString))

    println

    val times6 = (_: Int) * 6
    (1 - 2 - 3)
      .tap(v => println(s"initial: $v"))
      .pipe(times6)
      .tap(v => println(s"after times6: $v"))
      .pipe(scala.math.abs)
      .pipe(v => println(s"after scala.math.abs: $v"))

    println

    val doAll = times6 andThen scala.math.abs
    doAll(1 - 2 - 3) pipe println
  }
}
