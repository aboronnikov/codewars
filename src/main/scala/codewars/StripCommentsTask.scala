package codewars


/**
 * https://www.codewars.com/kata/51c8e37cee245da6b40000bd/train/scala
 */
object StripCommentsTask {

  def stripComments(str: String, markers: Set[Char]): String =


    markers.foldLeft(str)((str, char) => str.replace(char.toString, "<ss>"))
                                          .replaceAll("[ \\t]{0,}<ss>.*[ \\t]{0,}\\n", "\n")
                                          .replaceAll("[ \\t]{0,}<ss>.*[ \\t]{0,}", "")
                                          .replaceAll("[ \t]{0,}\n","\n")
                                          .replaceAll("[ \\t]+$", "")


  def main(args: Array[String]): Unit = {

    //val z = "aaaa $ dddd \n zzzzz".replaceAll("\\$.*\\n", "\n")

    //stripComments("aaaa $ dddd \n zzzzz", Set('$'))

    //println(stripComments("aaaa $ dddd \n zzzzz # fgg \n ggg", Set('$', '#')))

    //println(stripComments("1111 $qw 2222 #rt 777", Set('$', '#')))

    //println(stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", Set('#', '!')))

    //println(stripComments("\n§", Set('#', '§')).length)

    //println("bananas ".replaceAll("\\w+$", "")+"}")

    println(stripComments("", Set('#', '§')).length)

  }
}
