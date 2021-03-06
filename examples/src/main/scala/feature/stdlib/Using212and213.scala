package feature.stdlib

import java.io.{BufferedReader, FileReader}

import scala.util.{Failure, Success, Try}

import scala.util.Using
import scala.util.chaining._

import compat213.collections.unfold._
import util.formatting._

object Using212and213 extends util.App {

  printTextInLine("Using 2.12 and 2.13")

  def bufferedReader(fileName: String): BufferedReader =
    new BufferedReader(new FileReader(fileName))

  def readLines(reader: BufferedReader): Seq[String] =
    Iterator
      .unfold(()) { _ =>
        Option { reader.readLine() }.map(x => (x, ()))
      }
      .toList

  def tryLines(fileName: String): Try[Seq[String]] =
    Using(bufferedReader(fileName)) { reader =>
      readLines(reader)
    }

  def catFile(fileName: String): Unit =
    tryLines(fileName) match {
      case Failure(exception) => exception.toString pipe println
      case Success(lines)     => lines foreach println
    }

  catFile("README.md")

  "--------------------" pipe println

  def lines(fileName: String): Seq[String] =
    Using.resource(bufferedReader(fileName))(readLines)

  def catFile2(fileName: String): Unit = { // might throw an exception
    lines(fileName) foreach println
  }

  catFile2("README.md")

  "--------------------" pipe println

  final case class Resource(name: String) extends AutoCloseable {
    override def close(): Unit = println(s"Closing $name")

    def lines: List[String] = List(s"$name: line 1", s"$name: line 2")
  }

  val List(r1, r2, r3) = List("1st", "2nd", "3rd").map(Resource)

  val `try`: Try[Seq[String]] = for {
    lines1 <- Using(r1)(_.lines)
    lines2 <- Using(r2)(_.lines)
    lines3 <- Using(r3)(_.lines)
  } yield {
    lines1 ++ lines2 ++ lines3
  }

  `try` foreach {
    _ foreach println
  }
}
