package example

import org.apache.kafka.streams.StreamsBuilder

object Hello extends Greeting with App {

  val builder = new StreamsBuilder()

}

trait Greeting {
  lazy val greeting: String = "hello"
}
