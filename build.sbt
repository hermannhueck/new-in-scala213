name := "New in 2.13"

val scala212 = "2.12.8"
val scala213 = "2.13.0"
val supportedScalaVersions = List(scala212, scala213)

inThisBuild(
  Seq(
    scalaVersion       := scala212,
    crossScalaVersions := supportedScalaVersions,
    version            := "0.1.0-SNAPSHOT",
    scalacOptions ++= Seq(
      "-encoding", "UTF-8",     // source files are in UTF-8
      "-deprecation",           // warn about use of deprecated APIs
      "-unchecked",             // warn about unchecked type parameters
      "-feature",               // warn about misused language features
      //"-Ypartial-unification",  // allow the compiler to unify type constructors of different arities
      //"-Xlint",                 // enable handy linter warnings
      //"-Xfatal-warnings",        // turn compiler warnings into errors
    ),
  )
)

lazy val root = (project in file("."))
   .settings(
    publish / skip := true,
    libraryDependencies ++= Seq(
      "org.scala-lang.modules" %% "scala-collection-compat" % "2.1.1",
    ),
  )

// addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.10") // not yet available for 2.13.0
