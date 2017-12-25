import sbt._

object Dependencies {

  val kafkaVersion = "1.0.0"

  val kafka = "org.apache.kafka" % "kafka-streams" % kafkaVersion

  val backendDependencies = Seq(kafka)

}
