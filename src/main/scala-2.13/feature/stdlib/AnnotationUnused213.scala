package feature.stdlib

import scala.annotation.unused

import util.formatting._

object AnnotationUnused213 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Annotation @unused 2.13")

  // Equivalent of SuppressWarnings("unused")
  @unused // enable -Xlint
  val x = 5

  val y = 6
  println(y)

  prtLine()
}
