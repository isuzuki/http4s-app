name := "http4s-app"

version := "1.0"

scalaVersion := "2.12.4"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-target:jvm-1.8"
)

val http4sVersion = "0.17.5"

libraryDependencies ++= Seq(
  "ch.qos.logback" %  "logback-classic"     % "1.2.3",
  "org.http4s"     %% "http4s-blaze-server" % http4sVersion,
  "org.http4s"     %% "http4s-dsl"          % http4sVersion,
  "org.scalatest"  %% "scalatest"           % "3.0.4"        % "test"
)