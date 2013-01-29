import sbt._
import Keys._

object ModernWebBuild extends Build {
  lazy val basicSettings = Seq(
      scalaVersion  :=  "2.9.2",
      scalacOptions ++= Seq("–g:{source,line,vars}", "-deprecation", "-unchecked", "-encoding", "utf8"),
      crossPaths    :=  false,
      resolvers     ++= Seq(
        "Typesafe repo" at "http://repo.typesafe.com/typesafe/releases/"
      )
    )

  lazy val ui = Project(
      id    = "modern-web-ui",
      base  = file("modern-web-ui")
    )
    .settings(basicSettings: _*)
}
