package codewars

/**
 * https://www.codewars.com/kata/55983863da40caa2c900004e/train/scala
 */
object NextBiggerNumber2 {
  def nextBiggerNumber(n: Long): Long = {
    val digitsZipped = n.toString.map(_.asDigit).toList.zipWithIndex
    (for {
      toSwap <- digitsZipped.findLast(digit => digitsZipped.drop(digit._2).find(_._1 > digit._1).isDefined)
      beginning = digitsZipped.take(toSwap._2).map(_._1)
      tailing = digitsZipped.drop(toSwap._2 + 1).map(_._1)
      startInTail <- tailing.sorted.find(_ > toSwap._1)
      swapIndex = tailing.indexOf(startInTail)
      restTail = (tailing.take(swapIndex) ++ tailing.drop(swapIndex + 1) :+ toSwap._1).sorted
    } yield (beginning :+ startInTail) ++ restTail).map(_.mkString("").toLong).getOrElse(-1)
  }


  def main(args: Array[String]): Unit = {
    println(nextBiggerNumber(1234567890))
    //println(nextBiggerNumber(144))

    val l = List(1, 2,3).map { println("Hi"); _ + 1 }
    println(l)
  }
}
