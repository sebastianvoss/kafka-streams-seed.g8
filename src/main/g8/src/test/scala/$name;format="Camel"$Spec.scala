import org.scalatest._
import com.sebastianvoss.$name;format="Camel"$Test

class HelloSpec extends FlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    $name;format="Camel"$Test.greeting shouldEqual "hello"
  }
}
