import sbt._

object Dependencies {

  val kafkaVersion = "1.0.0"
  val cirisVersion = "0.5.0"

  val kafka = "org.apache.kafka" % "kafka-streams" % kafkaVersion

  val ciris = Seq(
    "is.cir" %% "ciris-core",
    "is.cir" %% "ciris-enumeratum",
    "is.cir" %% "ciris-generic",
    "is.cir" %% "ciris-refined",
    "is.cir" %% "ciris-spire",
    "is.cir" %% "ciris-squants"
  ).map(_ % cirisVersion)

  val backendDependencies = Seq(kafka) ++ ciris

}
