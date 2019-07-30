package compat213

package object string {

  implicit class StringOps(private val s: String) {
    import scala.util.Try
    def toIntOption: Option[Int] = Try(s.toInt).toOption
    def toDoubleOption: Option[Double] = Try(s.toDouble).toOption
    def toBooleanOption: Option[Boolean] = Try(s.toBoolean).toOption
  }
}
