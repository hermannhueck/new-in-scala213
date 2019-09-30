package compat213

import scala.util.Try

package object string {

  implicit class StringOps(private val s: String) extends AnyVal {
    def toIntOption: Option[Int]         = Try(s.toInt).toOption
    def toDoubleOption: Option[Double]   = Try(s.toDouble).toOption
    def toBooleanOption: Option[Boolean] = Try(s.toBoolean).toOption
  }
}
