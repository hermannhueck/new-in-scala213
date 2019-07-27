package feature.collections

import java.io.{BufferedReader, FileReader}

import scala.util.Using

object Unfold213 extends App {

  println("\n========== Coll.unfold 2.13")

  def bufferedReader(fileName: String) =
    new BufferedReader(new FileReader(fileName))

  def readLines(reader: BufferedReader) =
    Iterator.unfold(())(_ => Option(reader.readLine()).map(_ -> ())).toList

  def readLines2(reader: BufferedReader): List[String] = {
    val initialState: Unit = ()
    val iterator: Iterator[String] = Iterator.unfold(initialState) { _ =>
      val maybeLine: Option[String] = Option(reader.readLine())
      val maybeLineState: Option[(String, Unit)] = maybeLine.map(_ -> ())
      maybeLineState
    }
    iterator.toList
  }

  val lines: Seq[String] =
    Using.resource(bufferedReader("README.md"))(readLines2)

  lines foreach println

  println("==========\n")
}
