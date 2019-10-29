import sbt._

object Dependencies {

  val scalaCollectionCompatVersion = "2.1.2"
  val scalaTestVersion             = "3.0.8"
  val scalaCheckVersion            = "1.14.2"

  val scalaCollectionCompat = "org.scala-lang.modules" %% "scala-collection-compat" % scalaCollectionCompatVersion
  val scalaTest             = "org.scalatest"          %% "scalatest"               % scalaTestVersion
  val scalaCheck            = "org.scalacheck"         %% "scalacheck"              % scalaCheckVersion
}
