package feature.language

import java.io.{BufferedReader, FileReader}

import scala.util.Using
import scala.util.chaining._

import util.formatting._
import util.collections._

object TupleArrowSyntaxInPatternMatch212 extends App {

  prtTitleObjectName(this)

  lines("build.sbt") flatMap toWords pipe wordCount tap println

  prtLine()

  def bufferedReader(fileName: String): BufferedReader =
    new BufferedReader(new FileReader(fileName))

  def readLines(reader: BufferedReader): Seq[String] =
    Iterator.unfold(())(_ => Option(reader.readLine()).map((_, ()))).toList

  def lines(fileName: String): Seq[String] =
    Using.resource(bufferedReader(fileName))(readLines)

  def toWords(line: String): List[String] =
    line.split("\\W").toList.filter(_.length > 1)

  def wordCount(words: Seq[String]): Seq[(String, Int)] =
    words
      .map(w => w -> 1)
      .groupBy(_._1)
      .mapValues(_.length)
      .filter { case (k, v) => v > 1 } // omit words with just 1 occurrence
      .filterNot { case (k, v) => k.matches("^\\d.*") } // omit words starting with a digit
      .toList
      .sortWith { // sort 1st by occurence desc and then alphabetically
        case ((w1, c1), (w2, c2)) =>
          if (c1 == c2)
            w1 < w2
          else
            c2 < c1
      }
}
