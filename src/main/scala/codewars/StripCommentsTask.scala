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

}
