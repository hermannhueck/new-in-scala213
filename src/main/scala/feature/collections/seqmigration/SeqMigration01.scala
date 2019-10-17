package feature.collections.seqmigration

import scala.collection.compat.immutable.ArraySeq
import scala.collection.mutable.ArrayBuffer

import scala.util.chaining._
import util.formatting._

object SeqMigration01 extends App {

  prtTitleObjectName(this)

  prtSubTitle("SeqMigration Strategy 01")
  "----- view source code -----" tap println

  trait Order
  trait Food

  def orderFood(order: collection.Seq[Order]): collection.Seq[Food] = {
    Seq(new Food {})
  }

  val orderArray = Array(new Order {})

  val food2 = orderFood(orderArray)

  val food3  = orderFood(orderArray.toSeq)
  val food3b = orderFood(ArrayBuffer(new Order {}).toSeq)

  val food4 = orderFood(orderArray.toIndexedSeq)

  val food5 = orderFood(ArraySeq.unsafeWrapArray(Array(new Order {})))

  prtLine()
}
