import java.io.File
import scala.io.Source

//import org.scalatest._

object Test {
  def main(args: Array[String]) {
    var bad = Set[String]()
    for(file <- new File("tests").listFiles.toIterator if (file.isFile
        && file.getName.matches(".*\\.rkt"))) {

      // Read File
      var in = ""
      for(line <- Source fromFile file getLines) {
        in += line
      }

      // Read answer file
      val answerFile = new File(file + ".expected")
      var answer = ""
      for(line <- Source fromFile answerFile getLines) {
        answer += line
      }

      // Run test
      var out = Main.compile(in)

      if(out == answer) {
        println(file.getName + ": Good")
      } else {
        println(file.getName + ": Error")
        println(s"Input:    $in")
        println(s"Expected: $answer")
        println(s"Got:      $out")
        bad += file.getName
      }
    }
    println()
    if(bad == Set[String]()) {
      println("All Tests Passed!")
    } else {
      println("Failed Tests:")
      for(s <- bad) {
        println(s)
      }
    }
  }
}

//object Test extends FunSuite with BeforeAndAfter {
//  test("A") {
//    assert(true == true)
//  }
//  test("B") {
//    assert(true == false)
//  }
//}
