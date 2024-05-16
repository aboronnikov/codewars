package codewars

/**
 * https://www.codewars.com/kata/54b72c16cd7f5154e9000457
 */
object Morse2Task {

  def decodeBits(bits: String): String = {
    val clean = bits.reverse.dropWhile(_ == '0').reverse.dropWhile(_ == '0')
    if (!clean.contains("0"))
    //If the message contains only single dot then we cannot decode it. Because we cannot find range.
    //Actually I don't understand why this kata whants me to return 'E' when I have no chance to guess is it 'E' (.), 'I'(..) or may be 'S'(...)
      "."
    else
      seriousDecode(clean)
  }

  def seriousDecode(msg: String): String = {
    //Finding out the range by minimal sequence of 0 and 1
    val r = Math.min(
      (1 to msg.length).to(LazyList).find(i => msg.contains('1' + ("0" * i) + '1')).get,
      (1 to msg.length).to(LazyList).find(i => ("0" + msg + "0").contains('0' + ("1" * i) + '0')).get
    )
    msg.replaceAll("1" * r * 3, "-").replaceAll("1" * r, ".")
      .replaceAll("0" * r * 7, "   ")
      .replaceAll("0" * r * 3, " ")
      .replaceAll("0" * r, "")
  }

  def decodeMorse(msg: String): String =
    msg.split("\\s{3}").filter(_.nonEmpty).map(_.split("\\s{1}")
      .filter(_.nonEmpty).map(morseCodes1(_))
      .flatten.mkString + " ").mkString.trim

  def morseCodes1(str: String): String = {
    try {
      morseCodes(str)
    }
    catch {
      case x: NoSuchElementException => {
        println(s"$str is not morse code");
        ""
      }
    }
  }


  def morseCodes(str: String): String = {
    println(s"morseCodes for '$str' requested")

    "-"
  }


  def main(args: Array[String]): Unit = {
    //val s1 = "0000001010101010101111101010000"

    // val s2 = "000000110011"

    //println("decode result: " + decodeBits(s2))

    val decoded1 = decodeBits("10001")
    println(s"dot dashed: $decoded1")
    println("words: " + decoded1.split("\\s{7}").mkString(" / "))

    println("decode result: " + decodeMorse(decoded1))

    val z = ".... . -.--   .--- ..- -.. ."
    println(z.split("\\s{7}").mkString("|"))
    val z1 = z.split("\\s{7}").filter(_.nonEmpty).map(_.split("\\s{3}"))
    println(z1.flatten.mkString("|"))


    val s1 = ". . .   - ."
    println(s1.replace(" ", ""))

  }
}
