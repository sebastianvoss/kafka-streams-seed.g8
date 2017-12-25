import sbt._

object Dependencies {

  val kafkaVersion          = "1.0.0"
  val cirisVersion          = "0.5.0"
  val scalaLoggingVersion   = "3.7.2"
  val logbackVersion        = "1.2.3"
  val logbackEncoderVersion = "4.11"

  val kafka          = "org.apache.kafka"           % "kafka-streams"            % kafkaVersion
  val scalaLogging   = "com.typesafe.scala-logging" %% "scala-logging"           % scalaLoggingVersion
  val logback        = "ch.qos.logback"             % "logback-classic"          % logbackVersion
  val logbackEncoder = "net.logstash.logback"       % "logstash-logback-encoder" % logbackEncoderVersion

  val ciris = Seq(
    "is.cir" %% "ciris-core",
    "is.cir" %% "ciris-enumeratum",
    "is.cir" %% "ciris-generic",
    "is.cir" %% "ciris-refined",
    "is.cir" %% "ciris-spire",
    "is.cir" %% "ciris-squants"
  ).map(_ % cirisVersion)

  val backendDependencies = Seq(kafka, scalaLogging, logback, logbackEncoder) ++ ciris

}
