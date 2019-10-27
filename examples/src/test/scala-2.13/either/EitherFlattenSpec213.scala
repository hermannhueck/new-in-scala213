package either

import org.scalatest._

class EitherFlattenSpec213 extends FlatSpec with Matchers {

  "Flattening a 'Left(l)'" should "return a Left(l)" in {
    Left("Error").flatten shouldEqual Left("Error")
  }

  "Flattening a 'Right(Left(l)'" should "return a Left(l)" in {
    Right(Left("Error")).flatten shouldEqual Left("Error")
  }

  "Flattening a 'Right(Right(r)'" should "return a Right(r)" in {
    Right(Right(42)).flatten shouldEqual Right(42)
  }
}
