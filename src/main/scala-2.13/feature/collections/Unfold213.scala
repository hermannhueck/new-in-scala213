package feature.collections

import java.io.{BufferedReader, FileReader}

import scala.util.chaining._
import scala.util.Using

object Unfold213 extends App {

  println("\n========== List.unfold 2.13")

  List.unfold(10) {
    case 0 => None
    case s => Some(s * s -> (s - 1))
  } tap println

  println("\n========== Iterator.unfold 2.13")

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

  println("==========\n")
}
