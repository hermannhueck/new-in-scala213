package feature.collections.seq

import scala.util.chaining._
import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable, immutable.ArraySeq

object Seq213 extends App {

    println("\n========== Seq 2.12")

    // type Seq[+A] = scala.collection.immutable.Seq[A]
    // Seq is immutable
    val seq: Seq[Int] = Seq(1, 2, 3) tap println

    // --- The same is true for IndexedSeq

    trait Order
    trait Food
    def orderFood(order: Seq[Order]): Seq[Food] = {
        Seq(new Food{})
    }

    val food1 = orderFood(Array(new Order{}))

    // val food2 = orderFood(ArrayBuffer(new Order{}))
    //  [error]  found   : scala.collection.mutable.ArrayBuffer[feature.collections.seq.Seq213.Order]
    //  [error]  required: Seq[feature.collections.seq.Seq213.Order]
    //  [error]     val food = orderFood(ArrayBuffer(new Order{}))

    // toSeq wraps the mutable ArrayBuffer in an immutable Seq
    val food3 = orderFood(ArrayBuffer(new Order{}).toSeq)

    // make params and return types explicitly immutable in 2.12
    def orderFood2(order: immutable.Seq[Order]): immutable.Seq[Food] = {
        immutable.Seq(new Food{})
    }

    val food4 = orderFood2(ArraySeq(new Order{}))
    val food5 = orderFood2(ArrayBuffer(new Order{}).toSeq)

    // --- varargs

    // varargs accepts only immutable Seq
    def orderFood3(order: Order*): immutable.Seq[Food] = {
        immutable.Seq(new Food{})
    }

    val food6 = orderFood3(ArraySeq(new Order{}): _*)
    val food7 = orderFood3(ArrayBuffer(new Order{}).toSeq: _*)

    println("==========\n")
}