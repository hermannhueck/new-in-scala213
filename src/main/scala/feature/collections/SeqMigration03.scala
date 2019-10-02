package feature.collections

import scala.collection.compat.immutable.ArraySeq
import scala.collection.immutable
import scala.collection.mutable.ArrayBuffer

import util._

object SeqMigration03 extends App {

  prtTitleObjectName(this)

  prtSubTitle("SeqMigration Strategy 03")
  trait Order
  trait Food

  def orderFood(order: immutable.Seq[Order]): immutable.Seq[Food] = {
    immutable.Seq(new Food {})
  }

  val orderArray = Array(new Order {})

  val food2 = orderFood(orderArray.toIndexedSeq) // or use .toList

  val food3  = orderFood(orderArray.toIndexedSeq) // or use .toList
  val food3b = orderFood(ArrayBuffer(new Order {}).toIndexedSeq) // or use .toList

  val food4 = orderFood(orderArray.toIndexedSeq)

  val food5 = orderFood(ArraySeq.unsafeWrapArray(Array(new Order {})))

  prtLine()
}
