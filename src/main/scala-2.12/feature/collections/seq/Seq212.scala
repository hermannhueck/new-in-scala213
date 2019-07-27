package feature.collections.seq

import feature.stdlib.chaining._

import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable
import scala.collection.compat.immutable.ArraySeq

object Seq212 extends App {

    println("\n========== Seq 2.12")

    // type Seq[+A] = scala.collection.Seq[A]
    // Seq is not immutable
    val seq: Seq[Int] = Seq(1, 2, 3) tap println

    // --- The same is true for IndexedSeq

    trait Order
    trait Food

    def orderFood(order: Seq[Order]): Seq[Food] = {
        Seq(new Food{})
    }

    val food1 = orderFood(ArrayBuffer(new Order{}))
    val food2 = orderFood(Array(new Order{}))

    // make params and return types explicitly immutable in 2.12
    def orderFood2(order: immutable.Seq[Order]): immutable.Seq[Food] = {
        immutable.Seq(new Food{})
    }

    // ArraySeq from collections.compat library
    val food3 = orderFood2(ArraySeq.unsafeWrapArray(Array(new Order{})))
    val food4 = orderFood2(Array(new Order{}).to[immutable.Seq])

    // --- varargs

    // varargs accepts mutable or immutable Seq
    def orderFood3(order: Order*): immutable.Seq[Food] = {
        immutable.Seq(new Food{})
    }

    val food5 = orderFood3(ArraySeq.unsafeWrapArray(Array(new Order{})): _*)
    val food6 = orderFood3(Array(new Order{}).toSeq: _*)

    println("==========\n")
}