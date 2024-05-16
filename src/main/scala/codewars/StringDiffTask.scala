package codewars

/**
 * https://www.codewars.com/kata/5629db57620258aa9d000014/train/scala
 */
object StringDiffTask {
  def mix(s1: String, s2: String): String = {
    val map1 = s1.filter(_.isLower).groupBy(_.hashCode).filter(_._2.length>1)
    val map2 = s2.filter(_.isLower).groupBy(_.hashCode).filter(_._2.length>1)
    (map1.keySet ++ map2.keySet)
      .foldLeft(List(): List[(Int, String)])((res, k) =>
        (map1.get(k), map2.get(k)) match {
        case (Some(v1), Some(v2)) if v1.length == v2.length => res :+ (k, s"=:$v1")
        case (Some(v1), Some(v2)) => res :+ (k, (if (v1.length > v2.length) s"1:$v1" else s"2:$v2"))
        case (None, Some(v2)) => res :+ (k, s"2:$v2")
        case (Some(v1), None) => res :+ (k, s"1:$v1")
      }).sortBy(_._2).sortBy(-_._2.length).map(_._2).mkString("/")
  }
}
