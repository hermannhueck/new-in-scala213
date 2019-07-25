package features.future

import scala.concurrent._
import scala.concurrent.duration._
import scala.util.chaining._

object Future213 extends App {

    println("\n========== Future 2.13")

    implicit lazy val ec: ExecutionContext = ExecutionContext.global

    def squaredAsync(value: Int) = Future {
        ">>> squaredAsync" tap println
        value * value
    }

    def plus17(x: Int): Int = {
        ">>> map" tap println
        x + 17
    }

    "----- immediate execution:" tap println

    val f1: Future[Int] = squaredAsync(5) map plus17

    Await.result(f1, 3.seconds) tap println

    "----- Future.apply + Future#flatten:" tap println

    val f2: Future[Int] = Future.apply {
        ">>> apply" tap println
        squaredAsync(5)
    }.flatten map plus17

    Await.result(f2, 3.seconds) tap println

    "----- Future.delegate:" tap println

    val f3: Future[Int] = Future.delegate {
        ">>> delegate" tap println
        squaredAsync(5)
    } map plus17

    Await.result(f3, 3.seconds) tap println

    println("==========\n")
}