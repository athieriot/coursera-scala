package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = singletonSet(4)
    
    val m1000 = singletonSet(-1000)
    val p1000 = singletonSet(1000)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
      assert(contains(s2, 2), "Singleton")
      assert(!contains(s3, 4), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
      
      val u = union(s2, s3)
      assert(!contains(u, 1), "Union 1")
      assert(contains(u, 2), "Union 2")
      assert(contains(u, 3), "Union 3")
    }
  }
  
  test("intersect contains common elements") {
    new TestSets {
      val s = intersect(union(s1, s2), union(s2, s3))
      assert(!contains(s, 1), "intersect 1")
      assert(contains(s, 2), "intersect 2")
      assert(!contains(s, 3), "intersect 3")
    }
  }
  
  test("diff contains only s elements and not t") {
    new TestSets {
      val s = diff(union(s1, s2), union(s2, s3))
      assert(contains(s, 1), "diff 1")
      assert(!contains(s, 2), "diff 2")
      assert(!contains(s, 3), "diff 3")
    }
  }
  
  test("filter contains only computed elements") {
    new TestSets {
      val s = filter(union(union(union(s1, s2), union(s2, s3)), union(s3, s4)), t => t % 2 == 0)
      
      assert(!contains(s, 1), "filter 1")
      assert(contains(s, 2), "filter 2")
      assert(!contains(s, 3), "filter 3")
      assert(contains(s, 4), "filter 4")
    }
  }
  
  test("forall validate the function over all elements of the set") {
    new TestSets {
      val s = forall(union(s1, s2), t => t % 2 == 0)
      
      assert(!s, "not forall")
      
      val f = forall(union(s2, s4), t => t % 2 == 0)
      
      assert(f, "forall")
      
      val x = forall(union(m1000, p1000), t => true)
      
      assert(x, "exists")
    }
  }
  
  test("exists validate the function over at least one elements of the set") {
    new TestSets {
      val s = exists(union(s1, s2), t => t % 2 == 0)
      
      assert(s, "exists")
      
      val f = exists(union(s1, s3), t => t % 2 == 0)
      
      assert(!f, "not exists")
    }
  }
  
  test("map return a set of elements that match the function") {
    new TestSets {
      val s = map(union(s1, s2), t => t * 2)
      
      assert(!contains(s, 1), "map 1")
      assert(contains(s, 2), "map 2")
      assert(contains(s, 4), "map 4")
      
      assert(forall(s, t => t % 2 == 0), "map forall")
    }
  }
}
