package util

package object chaining {

  implicit class FSharpPipeOpertor[A](private val self: A) extends AnyVal {
    @inline def |>[B](f: A => B): B = f(self)
  }
}
