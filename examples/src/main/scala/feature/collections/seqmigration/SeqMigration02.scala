package feature.collections.seqmigration

import scala.collection.compat.immutable.ArraySeq
import scala.collection.immutable
import scala.collection.mutable.ArrayBuffer

import scala.util.chaining._
import util.formatting._

object SeqMigration02 extends util.App {

  printTextInLine("SeqMigration Strategy 02")
  "----- view source code -----" pipe println

  trait Order
  trait Food

  def orderFood(order: collection.Seq[Order]): immutable.Seq[Food] = {
    immutable.Seq(new Food {})
  }

  val orderArray = Array(new Order {})

  val food2 = orderFood(orderArray)

  val food3  = orderFood(orderArray.toSeq)
  val food3b = orderFood(ArrayBuffer(new Order {}).toSeq)

  val food4 = orderFood(orderArray.toIndexedSeq)

  val food5 = orderFood(ArraySeq.unsafeWrapArray(Array(new Order {})))
}
