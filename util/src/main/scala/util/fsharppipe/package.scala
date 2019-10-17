package scala.util

package object fsharppipe {

  implicit class FSharpPipeOperator[A](private val self: A) extends AnyVal {
    @inline def |>[B](f: A => B): B = f(self)
  }
}
