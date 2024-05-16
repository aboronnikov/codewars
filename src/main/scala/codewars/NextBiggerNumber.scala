package codewars

/**
 * https://www.codewars.com/kata/55983863da40caa2c900004e/train/scala
 */
object NextBiggerNumber {
  def nextBiggerNumber(n: Long): Long = {
    val digitsZipped = n.toString.map(_.asDigit).toList.zipWithIndex
    (for {
      toSwap <- digitsZipped.findLast(digit => digitsZipped.drop(digit._2).exists(_._1 > digit._1))
      beginning = digitsZipped.take(toSwap._2).map(_._1)
      tailing = digitsZipped.drop(toSwap._2 + 1).map(_._1)
      startInTail <- tailing.sorted.find(_ > toSwap._1)
      swapIndex = tailing.indexOf(startInTail)
      restTail = (tailing.take(swapIndex) ++ tailing.drop(swapIndex + 1) :+ toSwap._1).sorted
    } yield (beginning :+ startInTail) ++ restTail).map(_.mkString("").toLong).getOrElse(-1)
  }

}
