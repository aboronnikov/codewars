package codewars

import org.scalatest.flatspec.AnyFlatSpec

class StringDiffSpec extends AnyFlatSpec {
  "mix" should "pass basic tests" in {
    val testCases = List( //s1, s2, expected
      ("Are they here", "yes, they are here", "2:eeeee/2:yy/=:hh/=:rr"),
      ("uuuuuu", "uuuuuu", "=:uuuuuu"),
      ("looping is fun but dangerous", "less dangerous than coding",
        "1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg"),
      (" In many languages", " there's a pair of functions",
        "1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt"),
      ("Lords of the Fallen", "gamekult", "1:ee/1:ll/1:oo"),
      ("codewars", "codewars", "")
    )

    testCases.foreach {
      case (s1, s2, expected) => assertResult(expected, s"\nInput\n  s1 = $s1\n  s2 = $s2") {StringDiffTask.mix(s1, s2)}
    }
  }
}
