import Dependencies._
import ScalacOptions._

val projectName        = "New-in-Scala213"
val projectDescription = "New features in Scala 2.13"

val scala212               = "2.12.10"
val scala213               = "2.13.1"
val supportedScalaVersions = List(scala212, scala213)

inThisBuild(
  Seq(
    scalaVersion := scala213,
    crossScalaVersions := supportedScalaVersions,
    version := "0.1.0",
    publish / skip := true,
    libraryDependencies ++= Seq(
      scalaTest  % Test,
      scalaCheck % Test
    ),
    initialCommands :=
      s"""|
          |import scala.util.chaining._
          |import util.syntax.pipe._
          |println
          |""".stripMargin // initialize REPL
  )
)

lazy val root = (project in file("."))
  .aggregate(examples)
  .settings(
    name := projectName,
    description := projectDescription,
    crossScalaVersions := Seq.empty
  )

val slidesIn  = "slides-in"
val slidesOut = "slides-out"

lazy val slides = project // new documentation project
  .in(file(slidesIn)) // important: it must not be docs/
  .settings(
    mdocIn := file(slidesIn),
    mdocOut := file(slidesOut),
    mdocVariables := Map(
      "VERSION" -> version.value
    )
  )
  .dependsOn(examples)
  .enablePlugins(MdocPlugin)

lazy val examples = (project in file("examples"))
  .dependsOn(compat213, util)
  .enablePlugins(BuildInfoPlugin)
  .settings(
    name := "examples",
    description := "Examples for new features in Scala 2.13",
    Test / bloopGenerate := None,
    libraryDependencies += scalaCollectionCompat,
    scalacOptions ++= scalacOptionsFor(scalaVersion.value),
    // suppress unused import warnings in the scala repl
    console / scalacOptions := removeScalacOptionXlintUnusedForConsoleFrom(scalacOptions.value)
  )

lazy val compat213 = (project in file("compat213"))
  .settings(
    name := "compat213",
    description := "compat library providing features of Scala 2.13 backported to 2.12",
    scalacOptions ++= scalacOptionsFor(scalaVersion.value)
  )

lazy val util = (project in file("util"))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    name := "util",
    description := "Utilities",
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "build",
    scalacOptions ++= scalacOptionsFor(scalaVersion.value)
  )

// https://github.com/typelevel/kind-projector
addCompilerPlugin("org.typelevel" % "kind-projector" % "0.11.0" cross CrossVersion.full)
// https://github.com/oleg-py/better-monadic-for
addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
