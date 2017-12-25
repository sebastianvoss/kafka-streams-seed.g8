import Dependencies._

organization := "com.sebastianvoss",
scalaVersion := "2.12.4"
name := "$name$",

libraryDependencies ++= backendDependencies

scalafmtOnCompile := true

enablePlugins(JavaAppPackaging, GitVersioning, BuildInfoPlugin)

maintainer in Docker := "Sebastian Voss <sv@sebastianvoss.com>"
dockerBaseImage := "anapsix/alpine-java:8_server-jre_unlimited"
dockerExposedPorts := Seq(8080)

buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion)
buildInfoPackage := "com.sebastianvoss.buildinfo"
buildInfoOptions ++= Seq(BuildInfoOption.ToJson, BuildInfoOption.BuildTime)

javaOptions in Universal ++= Seq(
  "-J-Xmx2048m",
  "-J-XshowSettings:all",
  "-Duser.timezone=UTC"
)
