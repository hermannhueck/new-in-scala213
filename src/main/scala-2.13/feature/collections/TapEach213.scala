package feature.collections

object TapEach213 extends App {

  println("\n========== Coll#tapEach 2.13")

  val doubledAndSquared =
    List(1, 2, 3)
      .tapEach(x => println(s"value: $x"))
      .map(x => x * 2)
      .tapEach(x => println(s"doubled: $x"))
      .map(x => x * x)
      .tapEach(x => println(s"squared: $x"))

  println("==========\n")
}
