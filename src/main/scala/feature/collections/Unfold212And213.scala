package feature.collections

import java.io.{BufferedReader, FileReader}

import scala.util.chaining._
import scala.util.Using
import util.formatting._
import compat213.collections.unfold._

object Unfold212and213 extends App {

  prtTitleObjectName(this)

  "In 2.13 unfold is a factory method of different collection companion objects" tap println
  "In 2.12 unfold is provided by my compat213 library" tap println

  val unfoldFunction: Int => Option[(Int, Int)] = {
    case 0 => None
    case s => Some(((s * s), (s - 1)))
  }

  prtSubTitle("List.unfold")

  List.unfold(10)(unfoldFunction) tap println

  prtSubTitle("Iterator.unfold")

  def bufferedReader(fileName: String) =
    new BufferedReader(new FileReader(fileName))

  def readLines(reader: BufferedReader) =
    Iterator.unfold(())(_ => Option(reader.readLine()).map(_ -> ())).toList

  def readLines_dissected(reader: BufferedReader): List[String] = {
    val initialState: Unit = ()
    val iterator: Iterator[String] = Iterator.unfold(initialState) { _ =>
      val maybeLine: Option[String]              = Option(reader.readLine())
      val maybeLineState: Option[(String, Unit)] = maybeLine.map(_ -> ())
      maybeLineState
    }
    iterator.toList
  }

  val lines: Seq[String] =
    Using.resource(bufferedReader("README.md"))(readLines_dissected)

  lines foreach println

  prtLine()
}
