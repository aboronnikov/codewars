package codewars.unclear

import scala.annotation.tailrec

/**
 * https://www.codewars.com/kata/551f23362ff852e2ab000037/train/scala
 */
object PiramideSlideDownTask2 {
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

  //TODO aboronnikov: посмотреть:
  //def longestSlideDownOptimal(pyramid: List[List[Int]]): Int =
    //pyramid.foldRight(List.fill(pyramid.size + 1)(0))((top, bot) => top.zipWithIndex.map((x, i) => x + bot(i).max(bot(i + 1)))).head


  def main(args: Array[String]): Unit = {
    val pyramid = List(
      List(3),
      List(7, 4),
      List(2, 4, 6),
      List(8, 5, 9, 3)
    )

    //expected 23!
    println(longestSlideDown(pyramid))


    val x1 = Seq(1, 10, 9, 11, 6, 19, 2)
    x1 match {
      case (head :: elems) :+ last => println(s"head: $head"); println(s"last: $last")
    }
    println("maxes: " + x1.grouped(2).map(_.max).toSeq)
  }
}
