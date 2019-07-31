package compat213

package object either {

  implicit class RightOps[L, R](private val right: Right[L, R]) {
    def withLeft[LL](implicit ev: L <:< LL): Either[LL, R] = right.asInstanceOf[Either[LL, R]]
  }

  implicit class LeftOps[L, R](private val left: Left[L, R]) {
    def withRight[RR](implicit ev: R <:< RR): Either[L, RR] = left.asInstanceOf[Either[L, RR]]
  }
}