package jsonencoder213


sealed trait Gender extends Product with Serializable
case object Male extends Gender
case object Female extends Gender

case class Person(name: String, age: Int, isFemale: Boolean, email: String) {
  // def tupled: (String, Int, Gender, String) = Person.unapply(this).get
}
