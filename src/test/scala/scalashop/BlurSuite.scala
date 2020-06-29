package scalashop

import java.util.concurrent._
import scala.collection._
import org.junit._
import org.junit.Assert.assertEquals

class BlurSuite {

  @Test def `testSimpleBoxBlure`: Unit = {

    val i: Img = new Img(3, 3, List(2,2,2,2,1,2,2,2,2).toArray)
    val r = boxBlurKernel(i,1,1,1)
    val e: RGBA = 1
    assert(e == r, "expected 1 but was " + r)

    val i2: Img = new Img(3, 3, List(2,2,2,2,1,4,4,4,4).toArray)
    val r2 = boxBlurKernel(i2,1,1,1)
    assert(2 == r2, "expected 2 but was " + r2)


    val i3: Img = new Img(3, 3, List(2,2,2,2,1,4,4,4,4).toArray)
    val r3 = boxBlurKernel(i3,0,0,1)
    assert(1 == r3, "expected 1 but was " + r3)

    val i4: Img = new Img(3, 3, List(2,2,2,2,1,4,4,4,4).toArray)
    val r4 = boxBlurKernel(i4,0,2,2)
    assert(2 == r4, "expected 2 but was " + r4)

    val i5: Img = new Img(3, 4, List(2,2,2,2,1,4,4,4,4,5,5,5).toArray)
    val r5 = boxBlurKernel(i5,3,2,2)
    assert(3 == r5, "expected 4 but was " + r5)

//    val i6: Img = new Img(4, 3, List(1,2,3,4,3,8,9,5,7,6,1,3).toArray)
//    val r6 = boxBlurKernel(i6,2,3,2)
//    assert(4 == r6, "expected 4 but was " + r6)
  }

  @Rule def individualTestTimeout = new org.junit.rules.Timeout(10 * 1000)
}
