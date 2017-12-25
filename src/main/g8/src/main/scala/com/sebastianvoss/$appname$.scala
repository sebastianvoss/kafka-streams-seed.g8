package com.sebastianvoss

import java.util.Properties

import com.typesafe.scalalogging.LazyLogging
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.{Consumed, KafkaStreams, StreamsBuilder, StreamsConfig}

object $appname$ extends App with LazyLogging {

  val config = {
    val properties = new Properties()
    properties.put(StreamsConfig.APPLICATION_ID_CONFIG, $appname$)
    properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092")
    properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass)
    properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass)
    properties
  }

  val builder     = new StreamsBuilder()
  val stringSerde = Serdes.String()

  builder
    .stream[String, String]("topic1", Consumed.`with`(stringSerde, stringSerde, null, null))
    .foreach((k, v) => logger.info(s"key: \$k, value: \$v"))

  val topology = builder.build()

  val streams = new KafkaStreams(topology, config)

  sys.addShutdownHook({
    logger.info("Shutting down")
    streams.close()
  })

  streams.start()

}
