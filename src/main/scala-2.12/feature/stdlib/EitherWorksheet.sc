import compat213.either._

Right(5)
Right(5).withLeft[String]

Left("some error")
Left("some error").withRight[Int]