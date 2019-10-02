package feature.stdlib;

import scala.util.chaining._

import util._

object SInterpolatorInPatternMatches213 extends App {

  prtTitleObjectName(this)

  prtSubTitle("s-Interpolator in Pattern Matches 2.13")

  val dateString = "11-June-2019" tap println

  val s"$day-$month-$year" = dateString

  year tap println
  month tap println
  day tap println

  prtLine()
}
