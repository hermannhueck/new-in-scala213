package feature.language

/*
  see:
  https://docs.scala-lang.org/sips/byname-implicits.html
 */
import util._

object ByNameImplicits213 extends App {

  prtSubTitleObjectName(this)

  prtSubTitle("By Name Implicit Parameters 2.13")

  trait Foo {
    def next: Foo
  }

  object Foo {
    // wouldn't compile, if rec were a call by value parameter
    // remove the => and try to compile ...
    implicit def foo(implicit rec: => Foo): Foo =
      new Foo { def next = rec }
  }

  val foo = implicitly[Foo]
  assert(foo eq foo.next)

  prtLine()
}
