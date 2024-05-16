package codewars

import scala.collection.immutable.ListMap

/**
 * https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1/train/scala
 */
object SnailTask {

  def snail(xs: List[List[Int]]): List[Int] = {
    xs match {
      case Nil => Nil
      case x :: xs =>
        println(x)
        println(xs.transpose.reverse)
    }

    if (xs.isEmpty || xs.headOption.getOrElse(List()).isEmpty)
      List()
    else {
      val horizontal1 = (for {
        x <- 0 to xs.length / 2
        y <- x until xs.length - x
      } yield x -> xs(x)(y)).groupBy(_._1).map(a => a._1 -> a._2.map(_._2))

      val horizontal2 = Map((for {x <- xs.length / 2 + xs.length % 2 until xs.length
                              y <- xs.length - x - 1 to x
                              } yield (xs.length - x - 1) -> xs(x).reverse(y))
        .groupBy(_._1).map(a => a._1 -> a._2.map(_._2)).toSeq.sortBy(_._1):_*)

      val vertical1 = (for {x <- 0 until xs.length / 2
                            y <- x + 1 until xs.length - x - 1
                            } yield x -> xs(y)(x)).groupBy(_._1).map(a => a._1 -> a._2.map(_._2).reverse)

      val vertical2 = (for {x <- xs.length / 2 - xs.length % 2 until xs.length
                            y <- xs.length - x until x
                            } yield (xs.length - x - 1) -> xs(y)(x)).groupBy(_._1).map(a => a._1 -> a._2.map(_._2))

      ListMap(combineIterables(vertical1, combineIterables(horizontal2, combineIterables(vertical2, horizontal1))).toSeq.sortBy(_._1):_*).flatMap(_._2).toList
    }
  }

  def combineIterables[K, V](a: Map[K, Iterable[V]], b: Map[K, Iterable[V]]): Map[K, Iterable[V]] = {
    a ++ b.map { case (k, v) => k -> (v ++ a.getOrElse(k, Iterable.empty)) }
  }

}
