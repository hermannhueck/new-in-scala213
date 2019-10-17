package feature.collections

import util.formatting._

object TapEach212 extends App {

  prtTitleObjectName(this)

  prtSubTitle("Coll#tapEach 2.12")

  implicit class SeqOps[A](private val seq: Seq[A]) extends AnyVal {

    @inline def tapEach(f: A => Unit): Seq[A] = seq.map { a =>
      f(a); a
    }
  }

  implicit class ListOps[A](private val seq: List[A]) extends AnyVal {

    @inline def tapEach(f: A => Unit): List[A] = seq.map { a =>
      f(a); a
    }
  }

  implicit class VectorOps[A](private val seq: Vector[A]) extends AnyVal {

    @inline def tapEach(f: A => Unit): Vector[A] = seq.map { a =>
      f(a); a
    }
  }

  implicit class SetOps[A](private val seq: Set[A]) extends AnyVal {

    @inline def tapEach(f: A => Unit): Set[A] = seq.map { a =>
      f(a); a
    }
  }

  implicit class MapOps[K, V](private val seq: Map[K, V]) {

    @inline def tapEach(f: ((K, V)) => Unit): Map[K, V] = seq.map { pair =>
      f(pair); pair
    }
  }

  val doubledAndSquared: List[Int] = List(1, 2, 3)
    .tapEach(x => println(s"value: $x"))
    .map(x => x * 2)
    .tapEach(x => println(s"doubled: $x"))
    .map(x => x * x)
    .tapEach(x => println(s"squared: $x"))

  prtLine()
}
