package feature.stdlib;

import scala.util.chaining._

import util.formatting._

object SInterpolatorInPatternMatches213 extends App {

  prtTitleObjectName(this)

  prtSubTitle("s-Interpolator in Pattern Matches 2.13")

  val dateString = "11-June-2019" tap println

  val s"$day-$month-$year" = dateString

  year pipe println
  month pipe println
  day pipe println

  prtLine()
}
