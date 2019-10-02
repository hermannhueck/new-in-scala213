package compat213

package object chaining {

  implicit class ChainingOps[A](private val self: A) extends AnyVal {
    @inline def pipe[B](f: A => B): B   = f(self)
    @inline def |>[B](f: A => B): B     = self pipe f
    @inline def tap[B](f: A => Unit): A = self pipe (x => { f(x); x })
  }
}
