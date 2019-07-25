name := "New in 2.13"

val scala212 = "2.12.8"
val scala213 = "2.13.0"
val supportedScalaVersions = List(scala212, scala213)

inThisBuild(
  Seq(
    scalaVersion       := scala213,
    crossScalaVersions := supportedScalaVersions,
    version            := "0.1.0-SNAPSHOT",
  )
)


lazy val root = (project in file("."))
   .settings(
    publish / skip := true,
    libraryDependencies ++= Seq(
      "org.scala-lang.modules" %% "scala-collection-compat" % "2.1.1",
    ),
  )
