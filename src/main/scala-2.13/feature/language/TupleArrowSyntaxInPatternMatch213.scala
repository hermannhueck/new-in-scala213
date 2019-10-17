package feature.language

import scala.util.chaining._

import util.formatting._

object TupleArrowSyntaxInPatternMatch213 extends App {

  prtTitleObjectName(this)

  import feature.stdlib.Using212and213._

  val file = "build.sbt"
  lines(file) flatMap toWords pipe wordCount tap println

  prtLine()

  def toWords(line: String): List[String] =
    line.split("\\W").toList.filter(_.length > 1)

  def wordCount(words: Seq[String]): Seq[(String, Int)] =
    words
      .map(w => w -> 1)
      .groupBy(_._1)
      .view
      .mapValues(_.length)
      .filter { case k -> v => v > 1 } // omit words with just 1 occurrence
      .filterNot { case k -> v => k.matches("^\\d.*") } // omit words starting with a digit
      .toList
      .sortWith { // sort 1st by occurence desc and then alphabetically
        case (w1 -> c1, w2 -> c2) =>
          if (c1 == c2)
            w1 < w2
          else
            c2 < c1
      }
}
