package codewars

object RomanNumbersTask {
  private val romanLetters = List(
    Map(10 -> '?', 5 -> '?', 1 -> 'M'),
    Map(10 -> 'M', 5 -> 'D', 1 -> 'C'),
    Map(10 -> 'C', 5 -> 'L', 1 -> 'X'),
    Map(10 -> 'X', 5 -> 'V', 1 -> 'I')
  )

  def toRoman (num: Int):String = {
    ""
  }

  def fromRoman (num: String):Int = {
    num.length
  }

}
