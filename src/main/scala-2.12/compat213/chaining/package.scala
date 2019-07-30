package compat213

package object chaining {

  implicit class ChainingOps[A](private val a: A) {
    def pipe[B](f: A => B): B = f(a)
    def |>[B](f: A => B): B = a pipe f
    def tap[B](f: A => Unit): A = a pipe ( x => { f(x); x } )
  }
}
