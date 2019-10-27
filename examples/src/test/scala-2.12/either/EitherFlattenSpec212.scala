package either

import org.scalatest._
import compat213.either._

class EitherFlattenSpec212 extends FlatSpec with Matchers {

  "Flattening a 'Left(l)'" should "return a Left(l)" in {
    Left("Error").flatten == Left("Error") shouldEqual true
  }

  "Flattening a 'Right(Left(l)'" should "return a Left(l)" in {
    Right(Left("Error")).flatten == Left("Error") shouldEqual true
  }

  "Flattening a 'Right(Right(r)'" should "return a Right(r)" in {
    Right(Right(42)).flatten == Right(42) shouldEqual true
  }
}
