package feature.using

import scala.util.chaining._
import scala.util.{Try, Success, Failure, Using}

import java.io.{BufferedReader, FileReader}

object Using213 extends App {

  println("\n========== Using 2.13")

    def bufferedReader(fileName: String) =
        new BufferedReader(new FileReader(fileName))

    def readLines(reader: BufferedReader) =
        Iterator.unfold(())(_ => Option(reader.readLine()).map(_ -> ())).toList

    val try1: Try[Seq[String]] =
        Using(bufferedReader("README.md")) { reader => readLines(reader) }

    try1 match {
        case Failure(exception) => exception.toString tap println
        case Success(lines) => lines foreach println
    }

    "--------------------" tap println

    val lines: Seq[String] =
        Using.resource(bufferedReader("README.md")) { readLines }

    lines foreach println

    "--------------------" tap println

    final case class Resource(name: String) extends AutoCloseable {
        override def close(): Unit = println(s"Closing $name")
        def lines = List(s"$name: line 1", s"$name: line 2")
    }

    val List(r1, r2, r3) = List("1st", "2nd", "3rd").map(Resource)

    val try2: Try[Seq[String]] = for {
        lines1 <- Using(r1)(_.lines)
        lines2 <- Using(r2)(_.lines)
        lines3 <- Using(r3)(_.lines)
    } yield {
        lines1 ++ lines2 ++ lines3
    }

    try2 foreach { _ foreach println }

  println("==========\n")
}