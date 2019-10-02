package compat213

package object either {

  implicit class RightOps[L, R](private val right: Right[L, R]) extends AnyVal {

    @inline def withLeft[LL](implicit ev: L <:< LL): Either[LL, R] =
      right.asInstanceOf[Either[LL, R]]
  }

  implicit class LeftOps[L, R](private val left: Left[L, R]) extends AnyVal {

    @inline def withRight[RR](implicit ev: R <:< RR): Either[L, RR] =
      left.asInstanceOf[Either[L, RR]]
  }

  implicit class EitherOps[+L, +R](private val either: Either[L, R]) extends AnyVal {

    @inline def flatten[L1 >: L, RR](implicit ev: R <:< Either[L1, RR]): Either[L1, RR] =
      either.flatMap(x => x)
  }

  /* my 1st working impl

  implicit class LeftFlattenOps[L, R](private val left: Left[L, R]) extends AnyVal {
    @inline def flatten: Either[L, R] = left
  }

  implicit class RightFlattenOps[LL, L, R](private val right: Right[LL, Either[L, R]]) extends AnyVal {
    @inline def flatten: Either[L, R] = right.toOption.get
  }
 */
}
