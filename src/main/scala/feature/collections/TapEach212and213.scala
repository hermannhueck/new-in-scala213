package feature.collections

import util.formatting._
import scala.util.chaining._
import compat213.collections.tapeach._

object TapEach212and213 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Coll#tapEach 2.12 and 2.13")

  "In 2.13 unfold is a factory method of different collection companion objects" pipe println
  "In 2.12 unfold is provided by my compat213 library\n" pipe println

  val doubledAndSquared: List[Int] =
    List(1, 2, 3)
      .tapEach(x => println(s"value: $x"))
      .map(x => x * 2)
      .tapEach(x => println(s"doubled: $x"))
      .map(x => x * x)
      .tapEach(x => println(s"squared: $x"))

  prtLine()
}
