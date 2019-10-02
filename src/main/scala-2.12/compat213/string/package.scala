package compat213

import scala.util.Try

package object string {

  implicit class StringOps(private val s: String) extends AnyVal {
    @inline def toIntOption: Option[Int]         = Try(s.toInt).toOption
    @inline def toDoubleOption: Option[Double]   = Try(s.toDouble).toOption
    @inline def toBooleanOption: Option[Boolean] = Try(s.toBoolean).toOption
  }
}
