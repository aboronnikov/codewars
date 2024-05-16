package codewars

import org.scalatest.flatspec.AnyFlatSpec

class RomanNumeralsTest extends AnyFlatSpec {

  "Arabic" should "be converted to Roman" in {
    assert(RomanNumbersTask.toRoman(1) === "I", "1 converts to I")
    assert(RomanNumbersTask.toRoman(2) === "II", "2 converts to II")
    assert(RomanNumbersTask.toRoman(1666) === "MDCLXVI", "1666 converts to MDCLXVI")
    assert(RomanNumbersTask.toRoman(1664) === "MDCLXIV", "1664 converts to MDCLXIV")
    assert(RomanNumbersTask.toRoman(1995) === "MCMXCV", "1995 converts to MCMXCV")
    assert(RomanNumbersTask.toRoman(1005) === "MV", "1005 converts to MV")
  }
  "Roman" should "be converted to Arabic" in {
    assert(RomanNumbersTask.fromRoman("I") === 1, "I converts to 1")
    assert(RomanNumbersTask.fromRoman("II") === 2, "II converts to 2")
    assert(RomanNumbersTask.fromRoman("MDCLXVI") === 1666, "MDCLXVI converts to 1666")
    assert(RomanNumbersTask.fromRoman("MDCLXIV") === 1664, "MDCLXIV converts to 1664")
    assert(RomanNumbersTask.fromRoman("MCMXCV") === 1995, "MCMXCV converts to 1995")
    assert(RomanNumbersTask.fromRoman("MV") === 1005, "MV converts to 1005")
  }
}
