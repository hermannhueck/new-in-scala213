name := "New in 2.13"

val scala212 = "2.12.8"
val scala213 = "2.13.0"
val supportedScalaVersions = List(scala212, scala213)

inThisBuild(
  Seq(
    scalaVersion       := scala213,
    crossScalaVersions := supportedScalaVersions,
    version            := "0.1.0-SNAPSHOT",
    scalacOptions ++= Seq(
      "-encoding", "UTF-8",     // source files are in UTF-8
      "-deprecation",           // warn about use of deprecated APIs
      "-unchecked",             // warn about unchecked type parameters
      "-feature",               // warn about misused language features
      "-Xlint",                 // enable handy linter warnings
      //"-Xfatal-warnings",        // turn compiler warnings into errors
      // "-P:semanticdb:sourceroot:." // use only for bloopInstall
    ),
  )
)

lazy val root = (project in file("."))
   .settings(
    publish / skip := true,
    libraryDependencies ++= Seq(
      "org.scala-lang.modules" %% "scala-collection-compat" % "2.1.1",
    ),
    Compile / scalacOptions := {

      val thisBuildScalaOptions: Seq[String] = (ThisBuild / scalacOptions).value
      val compileScalaVersion: String = (Compile / scalaVersion).value

      if (compileScalaVersion.startsWith("2.13")) {
        println(">>>>>          compiling for Scala 2.13")
        // addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.10")
        // Scala 2.13: partial-unification already enabled --> no need to add it
        thisBuildScalaOptions
      } else {
        println(">>>>>          compiling for Scala 2.12")
        // Scala 2.12: enable partial-unification
        thisBuildScalaOptions :+ "-Ypartial-unification"
      }
    }
  )

// addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.10") // not yet available for 2.13.0
