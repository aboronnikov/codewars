package codewars

import codewars.TextAlignJustify.{LoremIpsum, justify}
import org.scalatest.flatspec.AnyFlatSpec

class TextAlignJustifyTest extends AnyFlatSpec {
  "justify" should "pass basic tests" in {
    val text = LoremIpsum
    val testCases = Seq(
      (15,
        """Lorem     ipsum
dolor sit amet,
consectetur
adipiscing
elit.
Vestibulum
sagittis  dolor
mauris,      at
elementum
ligula   tempor
eget.  In  quis
rhoncus   nunc,
at      aliquet
orci.  Fusce at
dolor  sit amet
felis  suscipit
tristique.  Nam
a     imperdiet
tellus.   Nulla
eu   vestibulum
urna.   Vivamus
tincidunt
suscipit  enim,
nec    ultrices
nisi   volutpat
ac.    Maecenas
sit        amet
lacinia   arcu,
non      dictum
justo.    Donec
sed   quam  vel
risus  faucibus
euismod.
Suspendisse
rhoncus rhoncus
felis        at
fermentum.
Donec     lorem
magna,
ultricies     a
nunc  sit amet,
blandit
fringilla nunc.
In   vestibulum
velit  ac felis
rhoncus
pellentesque.
Mauris       at
tellus    enim.
Aliquam
eleifend tempus
dapibus.
Pellentesque
commodo,   nisi
sit        amet
hendrerit
fringilla, ante
odio      porta
lacus,       ut
elementum justo
nulla et dolor."""),
      (20,
        """Lorem   ipsum  dolor
sit            amet,
consectetur
adipiscing     elit.
Vestibulum  sagittis
dolor   mauris,   at
elementum     ligula
tempor eget. In quis
rhoncus   nunc,   at
aliquet  orci. Fusce
at  dolor  sit  amet
felis       suscipit
tristique.   Nam   a
imperdiet    tellus.
Nulla  eu vestibulum
urna.        Vivamus
tincidunt   suscipit
enim,  nec  ultrices
nisi   volutpat  ac.
Maecenas   sit  amet
lacinia   arcu,  non
dictum  justo. Donec
sed  quam  vel risus
faucibus    euismod.
Suspendisse  rhoncus
rhoncus   felis   at
fermentum.     Donec
lorem         magna,
ultricies a nunc sit
amet,        blandit
fringilla  nunc.  In
vestibulum  velit ac
felis        rhoncus
pellentesque. Mauris
at    tellus   enim.
Aliquam     eleifend
tempus      dapibus.
Pellentesque
commodo,   nisi  sit
amet       hendrerit
fringilla, ante odio
porta    lacus,   ut
elementum      justo
nulla et dolor."""),
      (25, """Lorem   ipsum  dolor  sit
amet,         consectetur
adipiscing          elit.
Vestibulum sagittis dolor
mauris,    at   elementum
ligula  tempor  eget.  In
quis   rhoncus  nunc,  at
aliquet  orci.  Fusce  at
dolor   sit   amet  felis
suscipit tristique. Nam a
imperdiet  tellus.  Nulla
eu    vestibulum    urna.
Vivamus         tincidunt
suscipit     enim,    nec
ultrices   nisi  volutpat
ac.   Maecenas  sit  amet
lacinia  arcu, non dictum
justo. Donec sed quam vel
risus  faucibus  euismod.
Suspendisse       rhoncus
rhoncus      felis     at
fermentum.   Donec  lorem
magna,  ultricies  a nunc
sit     amet,     blandit
fringilla     nunc.    In
vestibulum velit ac felis
rhoncus     pellentesque.
Mauris  at  tellus  enim.
Aliquam  eleifend  tempus
dapibus.     Pellentesque
commodo,  nisi  sit  amet
hendrerit fringilla, ante
odio   porta   lacus,  ut
elementum  justo nulla et
dolor."""),
      (30, """Lorem  ipsum  dolor  sit amet,
consectetur  adipiscing  elit.
Vestibulum    sagittis   dolor
mauris,  at  elementum  ligula
tempor  eget.  In quis rhoncus
nunc,  at  aliquet orci. Fusce
at   dolor   sit   amet  felis
suscipit   tristique.   Nam  a
imperdiet   tellus.  Nulla  eu
vestibulum    urna.    Vivamus
tincidunt  suscipit  enim, nec
ultrices   nisi  volutpat  ac.
Maecenas   sit   amet  lacinia
arcu,  non dictum justo. Donec
sed  quam  vel  risus faucibus
euismod.  Suspendisse  rhoncus
rhoncus  felis  at  fermentum.
Donec lorem magna, ultricies a
nunc    sit    amet,   blandit
fringilla  nunc. In vestibulum
velit    ac    felis   rhoncus
pellentesque. Mauris at tellus
enim.  Aliquam eleifend tempus
dapibus. Pellentesque commodo,
nisi    sit   amet   hendrerit
fringilla,   ante  odio  porta
lacus,   ut   elementum  justo
nulla et dolor."""),
      (100, """Lorem  ipsum  dolor  sit  amet,  consectetur  adipiscing  elit. Vestibulum sagittis dolor mauris, at
elementum  ligula  tempor eget. In quis rhoncus nunc, at aliquet orci. Fusce at dolor sit amet felis
suscipit  tristique.  Nam  a  imperdiet tellus. Nulla eu vestibulum urna. Vivamus tincidunt suscipit
enim,  nec  ultrices  nisi  volutpat ac. Maecenas sit amet lacinia arcu, non dictum justo. Donec sed
quam  vel risus faucibus euismod. Suspendisse rhoncus rhoncus felis at fermentum. Donec lorem magna,
ultricies  a  nunc  sit  amet,  blandit  fringilla  nunc.  In  vestibulum  velit  ac  felis  rhoncus
pellentesque. Mauris at tellus enim. Aliquam eleifend tempus dapibus. Pellentesque commodo, nisi sit
amet hendrerit fringilla, ante odio porta lacus, ut elementum justo nulla et dolor."""),
      (text.length, text),
      (800, text)
    )

    testCases.foreach {
      pars =>
        assertResult(pars._2,
          s"\nInputs\n text = \"$text\"\n width = ${pars._1}")(
          justify(text, pars._1))
    }

    assertResult("", "\nInputs\n text = \"\"\n width = 10")(justify("", 10))
  }
}
