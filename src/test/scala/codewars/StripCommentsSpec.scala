package codewars

import codewars.StripCommentsTask.stripComments
import org.scalatest._
import flatspec._

class StripCommentsSpec extends AnyFlatSpec {
  //this function is used to escape the newlines in your test output for easier reading
  val unbleach = (s: String) => s.replace("\n", "\\n").replace("\t", "\\t")

  "stripComments" should "pass basic tests" in {
    val testCases = List(
      ("apples, pears # and bananas\ngrapes\nbananas !apples", Set('#', '!'), "apples, pears\ngrapes\nbananas"),
      ("a #b\nc\nd $e f g", Set('#', '$'), "a\nc\nd"),
      (" a #b\nc\nd $e f g", Set('#', '$'), " a\nc\nd"),
      ("apples, pears\t# and bananas\ngrapes \t\nbananas\t !apples", Set('#', '!'), "apples, pears\ngrapes\nbananas")
    )

    testCases.foreach {
      case (str, markers, expected) => {
        val clue = s"\nInput\n  str = ${unbleach(str)}\n  markers = $markers"
        assertResult(unbleach(expected), clue) {unbleach(stripComments(str, markers))}
      }
    }
  }
}