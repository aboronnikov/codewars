package codewars

import scala.annotation.tailrec

/**
 * https://www.codewars.com/kata/551f23362ff852e2ab000037/train/scala
 */
object PiramideSlideDownTask {
  def longestSlideDown(pyramid: List[List[Int]]): Int = {

    @tailrec
    def step(pyramid: List[List[Int]], pos: Int, prev: Seq[Int]): Int = {
      if (pos == pyramid.length)
        prev.max
      else {
        val newPrev =
          for {
            i <- 0 until pos
            seq = Seq(prev(i) + pyramid(pos)(i), prev(i) + pyramid(pos)(i + 1))
          } yield seq

        val newPrev1 = newPrev.flatten.toList match {
          case (head :: elems) :+ last => head +: elems.grouped(2).map(_.max).toSeq :+last
          case _ =>newPrev.flatten
        }
        //TODO aboronnikov: remove prints
        println(s"pos: $pos; pyramid level: ${pyramid(pos)}")
        println(s"newPrev: $newPrev")
        println(s"newPrev1: $newPrev1")

        step(pyramid, pos + 1, newPrev1)
      }
    }

    if (pyramid.length == 1)
      pyramid(0)(0)
    else
      step(pyramid, 1, pyramid(0))
  }

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
    println("maxes: "+x1.grouped(2).map(_.max).toSeq)
  }
}
