package recfun

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.security.InvalidParameterException

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
  import Main.pascal
  test("pascal: col=-1,row=67") {
    intercept[InvalidParameterException] {
      assert(pascal(-1,67) === 1)  
    }
  }
  
  test("pascal: col=0,row=2") {
    assert(pascal(0,2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1,2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1,3) === 3)
  }
  
  test("pascal: col=0,row=0") {
    assert(pascal(0,0) === 1)
  }
  
  test("pascal: col=8,row=20") {
    assert(pascal(8,20) === 125970)
  }
}
