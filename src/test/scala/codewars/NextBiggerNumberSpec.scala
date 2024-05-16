package codewars

import codewars.NextBiggerNumber.nextBiggerNumber
import org.scalatest.flatspec.AnyFlatSpec

class NextBiggerNumberSpec extends AnyFlatSpec {
  "nextBiggerNumber" should "pass basic tests" in {
    val testCases = List( //n, expected
      (12, 21),
      (21, -1),
      (513, 531),
      (2017, 2071),
      (414, 441),
      (144, 414),
      (1234567890, 1234567908)
    )

    testCases.foreach {
      case (n, expected) => assertResult(expected, s"\nInput\n  n = $n") {
        nextBiggerNumber(n)
      }
    }
  }
}
