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
      "-feature"      // warn about misused language features
    ),
    libraryDependencies ++= Seq(
      scalaTest,
      scalaCheck
    )
  )
)

lazy val root = (project in file("."))
  .dependsOn(compat213, util)
  .enablePlugins(BuildInfoPlugin)
  .settings(
    bloopGenerate in Test := None,
    libraryDependencies += "org.scala-lang.modules" %% "scala-collection-compat" % "2.1.2",
    Compile / scalacOptions ++= {
      val sv = (Compile / scalaVersion).value
      println(s"\n>>>>>          compiling for Scala $sv\n")
      if (sv.startsWith("2.13"))
        Seq(
          "-Xlint:-unused,_" // suppress unused warnings in 2.13
          // "-Xlint"
        )
      else
        Seq(
          "-Ypartial-unification", // (removed in scala 2.13) allow the compiler to unify type constructors of different arities
          "-language:higherKinds", // (not required since scala 2.13.1) suppress warnings when using higher kinded types
          "-Xlint"                 // enable handy linter warnings
        )
    }
  )

lazy val compat213 = (project in file("compat213"))
  .settings(
    name := "compat213",
    description := "compat library providing scala 2.13 extensions for scala 2.12"
  )

lazy val util = (project in file("util"))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    name := "util",
    description := "Utilities",
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "build"
  )

// https://github.com/typelevel/kind-projector
addCompilerPlugin("org.typelevel" % "kind-projector" % "0.11.0" cross CrossVersion.full)
// https://github.com/oleg-py/better-monadic-for
addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
