package feature.collections

import scala.util.chaining._

import scala.collection.immutable
import scala.collection.immutable.ArraySeq
import scala.collection.mutable.ArrayBuffer

import util.formatting._

object Seq213 extends util.App {

  printTextInLine("Seq 2.13")

  // type Seq[+A] = scala.collection.immutable.Seq[A]
  // Seq is immutable
  val seq: Seq[Int] = Seq(1, 2, 3) tap println

  // --- The same is true for IndexedSeq

  trait Order
  trait Food

  // type Seq[+A] is scala.collection.immutable.Seq[A] in 2.13 (no longer scala.collection.Seq as in 2.12)
  def orderFood(order: Seq[Order]): Seq[Food] = {
    Seq(new Food {})
  }

  // We can NOT pass a mutable ArrayBuffer where an immutable Seq is expected.
  // ArrayBuffer is not implicitly converted (and copied) like Array
  // val food1 = orderFood(ArrayBuffer(new Order{}))
  //  [error]  found   : scala.collection.mutable.ArrayBuffer[feature.collections.seq.Seq213.Order]
  //  [error]  required: Seq[feature.collections.seq.Seq213.Order]
  //  [error]     val food = orderFood(ArrayBuffer(new Order{}))

  val orderArray = Array(new Order {})

  // We can pass a mutable Array where an immutable Seq is expected.
  // val food2 = orderFood(orderArray) // But compiler produces a warning!!!
  // [warn] Implicit conversions from Array to immutable.IndexedSeq are implemented by copying;
  // [warn] Use the more efficient non-copying ArraySeq.unsafeWrapArray or an explicit toIndexedSeq call
  // !!! for warning free solution see food6 !!!

  // toSeq (or toIndexedSeq) wraps the mutable ArrayBuffer in an immutable Seq
  val food3  = orderFood(orderArray.toSeq)
  val food3b = orderFood(ArrayBuffer(new Order {}).toSeq)
  val food4  = orderFood(orderArray.toIndexedSeq)

  // Alternatively use the new collection ArraySeq, which is an immutable Array
  val food5 = orderFood(ArraySeq(new Order {}))
  val food6 = orderFood(ArraySeq.unsafeWrapArray(Array(new Order {})))

  // make params and return types explicitly immutable in 2.12
  def orderFood2(order: immutable.Seq[Order]): immutable.Seq[Food] = {
    immutable.Seq(new Food {})
  }

  val food7 = orderFood2(ArrayBuffer(new Order {}).toSeq)

  // --- varargs

  // varargs accepts only immutable Seq
  def orderFood3(order: Order*): immutable.Seq[Food] = {
    immutable.Seq(new Food {})
  }

  val food8 = orderFood3(ArraySeq(new Order {}): _*)
  val food9 = orderFood3(ArrayBuffer(new Order {}).toSeq: _*)
}
