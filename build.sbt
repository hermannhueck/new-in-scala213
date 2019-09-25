name := "New in Scala 2.13"

val scala212               = "2.12.10"
val scala213               = "2.13.1"
val supportedScalaVersions = List(scala212, scala213)

val scalaTest  = "org.scalatest"  %% "scalatest"  % "3.0.8"  % Test withSources () withJavadoc ()
val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.14.2" % Test withSources () withJavadoc ()

inThisBuild(
  Seq(
    scalaVersion := scala213,
    crossScalaVersions := supportedScalaVersions,
    version := "0.1.0",
    publish / skip := true,
    scalacOptions ++= Seq(
      "-encoding",
      "UTF-8",        // source files are in UTF-8
      "-deprecation", // warn about use of deprecated APIs
      "-unchecked",   // warn about unchecked type parameters
      "-feature",     // warn about misused language features
      "-Xlint"        // enable handy linter warnings
    ),
    libraryDependencies ++= Seq(
      scalaTest,
      scalaCheck
    )
  )
)

lazy val root = (project in file(".")).settings(
  bloopGenerate in Test := None,
  libraryDependencies += "org.scala-lang.modules" %% "scala-collection-compat" % "2.1.2",
  Compile / scalacOptions ++= {
    val sv = (Compile / scalaVersion).value
    if (sv.startsWith("2.13")) {
      println(s"\n>>>>>          compiling for Scala $sv\n")
      Seq() // Scala 2.13: partial-unification already enabled
    } else {
      println(s"\n>>>>>          compiling for Scala $sv\n")
      Seq("-Ypartial-unification") // Scala 2.12: enable partial-unification
    }
  }
)

// addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3")
