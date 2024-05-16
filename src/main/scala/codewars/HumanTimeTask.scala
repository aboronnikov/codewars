package codewars

/**
 * https://www.codewars.com/kata/52742f58faf5485cae000b9a
 */
object HumanTimeTask {

  val Seconds = 1
  val Minutes = 60
  val Hours = 60 * Minutes
  val Days = 24 * Hours
  val Years = 365 * Days

  val allUnits = Seq(Years -> "year", Days -> "day", Hours -> "hour", Minutes -> "minute", Seconds -> "second")

  def formatDuration(seconds: Int): String = {
    val res = allUnits.foldLeft((Seq(): Seq[String], seconds))((res, unit) => {
      val cur = takeUnit(res._2, unit._1, unit._2)
      (res._1 :+ cur._1, cur._2)
    })._1.filter(_.nonEmpty).mkString(", ")
    val withAnd = res.lastIndexOf(", ") match {
      case -1 => res
      case ind => res.take(ind) + " and" + res.drop(ind + 1)
    }
    if(withAnd.isBlank) "now" else withAnd
  }

  def takeUnit(seconds: Int, unit: Int, title: String): (String, Int) =
    (seconds / unit match {
      case 0 => ""
      case 1 => 1 + " " + title
      case quantity => quantity + " " + title + "s"
    }, seconds % unit)

  def main(args: Array[String]): Unit = {

    println(takeUnit(125, Minutes, "minute"))
    println(takeUnit(63, Minutes, "minute"))

    println(formatDuration(1234567))
    println(formatDuration(0))


    println("a, b, c".patch("a, b, c".lastIndexOf(","), " and", 1))
  }

}
