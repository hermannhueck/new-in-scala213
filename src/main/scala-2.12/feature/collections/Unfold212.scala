package feature.collections

import java.io.{BufferedReader, FileReader}

import scala.util.Using
import scala.util.chaining._

import compat213.collections._
import util._

object Unfold212 extends App {

  prtTitleObjectName(this)

  val unfoldFunction: Int => Option[(Int, Int)] = {
    case 0 => None
    case s => Some(((s * s), (s - 1)))
  }

  prtSubTitle("Stream.unfold 2.12")

  Stream.unfold(10)(unfoldFunction).toList tap println

  prtSubTitle("List.unfold 2.12")

  List.unfold(10)(unfoldFunction) tap println

  prtSubTitle("Iterator.unfold 2.12")

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
