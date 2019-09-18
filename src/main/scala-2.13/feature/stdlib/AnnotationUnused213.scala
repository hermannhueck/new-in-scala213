package feature.stdlib

import scala.annotation.unused

object AnnotationUnused213 extends App {

  println("\n========== Annotation @unused 2.13")

  // Equivalent of SuppressWarnings("unused")
  @unused // enable -Xlint
  val x = 5

  val y = 6
  println(y)

  println("==========\n")
}
