package codewars

import scala.annotation.tailrec

object TextAlignJustify {

  val LoremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis dolor mauris, at elementum ligula tempor eget. In quis rhoncus nunc, at aliquet orci. Fusce at dolor sit amet felis suscipit tristique. Nam a imperdiet tellus. Nulla eu vestibulum urna. Vivamus tincidunt suscipit enim, nec ultrices nisi volutpat ac. Maecenas sit amet lacinia arcu, non dictum justo. Donec sed quam vel risus faucibus euismod. Suspendisse rhoncus rhoncus felis at fermentum. Donec lorem magna, ultricies a nunc sit amet, blandit fringilla nunc. In vestibulum velit ac felis rhoncus pellentesque. Mauris at tellus enim. Aliquam eleifend tempus dapibus. Pellentesque commodo, nisi sit amet hendrerit fringilla, ante odio porta lacus, ut elementum justo nulla et dolor."

  def justify(text: String, width: Int): String = {
    @tailrec
    def step(restWords: Seq[String], result: Seq[String]):String={



    }


    ""
  }

  def main(args: Array[String]): Unit = {
    //15,20,25,30


    println(LoremIpsum.split(" ").mkString("\n"))

    println("max: "+LoremIpsum.split(" ").map(a=> (a,a.length)).maxBy(_._2))

  }

}
