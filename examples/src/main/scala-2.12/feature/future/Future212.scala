package feature.future

import scala.concurrent._
import scala.concurrent.duration._

import scala.util.chaining._

import util.formatting._

object Future212 extends util.App {

  printTextInLine("Future 2.12")

  implicit lazy val ec: ExecutionContext = ExecutionContext.global

  def squaredAsync(value: Int) = Future {
    ">>> squaredAsync" pipe println
    value * value
  }

  def plus17(x: Int): Int = {
    ">>> map" pipe println
    x + 17
  }

  "----- immediate execution:" pipe println

  val f1: Future[Int] = squaredAsync(5) map plus17

  Await.result(f1, 3.seconds) pipe println

  "----- Future.apply(thunk).flatten:" pipe println

  val f2: Future[Int] = Future.apply {
    ">>> apply" pipe println
    squaredAsync(5)
  }.flatten map plus17

  Await.result(f2, 3.seconds) pipe println

  "----- Future.unit.flatMap(_ => body):" pipe println

  val f3: Future[Int] = Future.unit.flatMap { _ =>
    ">>> apply" pipe println
    squaredAsync(5)
  } map plus17

  Await.result(f3, 3.seconds) pipe println
}
