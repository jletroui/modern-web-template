import sbt._
import Keys._

object ModernWebBuild extends Build {
  lazy val basicSettings = Seq(
      scalaVersion  :=  "2.9.2",
      scalacOptions ++= Seq("-Ydependent-method-types", "–g:{source,line,vars}", "-deprecation", "-unchecked", "-encoding", "utf8"),
      crossPaths    :=  false,
      resolvers     ++= Seq(
        "typesafe repo" at "http://repo.typesafe.com/typesafe/releases/",
        "spray repo"    at "http://repo.spray.io"
      )
    )

  lazy val ui = Project(
      id    = "modern-web-ui",
      base  = file("modern-web-ui")
    )
    .settings(basicSettings: _*)
    .settings(
      libraryDependencies ++= Seq(
        "com.typesafe.akka" % "akka-actor" % V.akka,
        "io.spray" % "spray-can" % V.spray,
        "io.spray" % "spray-routing" % V.spray
      )
    )

  object V {
    val akka = "2.0.5"
    val spray = "1.0-M7"
  }
}
