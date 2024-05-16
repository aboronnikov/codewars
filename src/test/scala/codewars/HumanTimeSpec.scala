package codewars

import org.scalatest.flatspec.AnyFlatSpec

class HumanTimeSpec extends AnyFlatSpec {
  "HumanTime.formatDuration" should "pass basic tests" in {
    val testCases = List( //seconds, expected
      (0, "now"),
      (1, "1 second"),
      (62, "1 minute and 2 seconds"),
      (120, "2 minutes"),
      (3600, "1 hour"),
      (3662, "1 hour, 1 minute and 2 seconds")
    )

    testCases.foreach {
      case (seconds, expected) => assertResult(expected, s"\nInput:\n  seconds = $seconds") {HumanTimeTask.formatDuration(seconds)}
    }
  }
}
