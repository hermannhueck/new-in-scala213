package compat213

package object chaining {

  implicit class ChainingOps[A](private val self: A) extends AnyVal {
    def pipe[B](f: A => B): B   = f(self)
    def |>[B](f: A => B): B     = self pipe f
    def tap[B](f: A => Unit): A = self pipe (x => { f(x); x })
  }
}
