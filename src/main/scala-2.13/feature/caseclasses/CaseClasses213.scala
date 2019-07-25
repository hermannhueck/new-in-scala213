package feature.caseclasses

import scala.util.chaining._

object CaseClasses213 extends App {

  println("\n========== Case Classes 2.13")

  sealed trait Gender extends Product with Serializable
  case object Male extends Gender
  case object Female extends Gender

  case class Person(name: String, age: Int, gender: Gender, email: String)

  val johndoe = Person("John Doe", 42, Male, "john@doe.com")

  johndoe.productElementNames foreach println

  println
  johndoe.productElementName(0) tap (name => print(s"$name: "))
  johndoe.productElement(0) tap println
  johndoe.productElementName(1) tap (name => print(s"$name: "))
  johndoe.productElement(1) tap println

  println
  def elementNameAndValue(p: Person, index: Int): String =
    s"${p.productElementName(index)}: ${p.productElement(index)}"

  (0 until johndoe.productArity).toList foreach { index =>
    elementNameAndValue(johndoe, index) tap println
  }

  println
  def productElementToJson(p: Product, index: Int): String =
    s"""{ "${p.productElementName(index)}": ${p.productElement(index)} }"""

  def productToJson(p: Product): String =
    (0 until johndoe.productArity)
      .toList
      .map { index => productElementToJson(johndoe, index) }
      .mkString("{ ", ", ", " }")

  productToJson(johndoe) tap println

  println("==========\n")
}