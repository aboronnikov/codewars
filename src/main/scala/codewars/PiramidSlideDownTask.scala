package codewars

import scala.annotation.tailrec

/**
 * https://www.codewars.com/kata/551f23362ff852e2ab000037/train/scala
 */
object PiramidSlideDownTask {
  def longestSlideDown(pyramid: List[List[Int]]): Int = {
    @tailrec
    def step(pyramid: List[List[Int]], pos: Int, prevSums: Seq[Int]): Int = {
      if (pos == pyramid.length)
        prevSums.max
      else {
        val pairs =
          for {
            i <- 0 until pos
            seq = Seq(prevSums(i) + pyramid(pos)(i), prevSums(i) + pyramid(pos)(i + 1))
          } yield seq

        val nextSums = pairs.flatten.toList match {
          //We can filter out min elements from pairs of numbers (except head and last)
          case (head :: elems) :+ last => head +: elems.grouped(2).map(_.max).toSeq :+ last
          case _ => pairs.flatten
        }

        step(pyramid, pos + 1, nextSums)
      }
    }

    if (pyramid.length == 1)
      pyramid(0)(0)
    else
      step(pyramid, 1, pyramid(0))
  }

}
