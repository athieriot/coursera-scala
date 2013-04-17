package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }
  
  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }
  
  test("time for some frequency table") {
    assert(times(List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd')) === List(('h',1), ('e',1), ('l',3), ('o',2), (',',1), (' ',1), ('w',1), ('r',1), ('d',1)))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }
  
  test("singleton for nil") {
    assert(singleton(Nil) === false)
  }
  test("singleton for some tree") {
    assert(singleton(List(Leaf('a',2), Leaf('b',3))) === false)
  }
  test("singleton for multi tree") {
    assert(singleton(List(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5))) === true)
  }

  test("combine of Nil") {
    assert(combine(Nil) === Nil)
  }
  
  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }
  
  test("until some leaf") {
    assert(until(singleton, combine)(List(Leaf('e',1), Leaf('t',2), Leaf('x',3))) == List(Fork(Fork(Leaf('e',1), Leaf('t',2), List('e', 't'), 3), Leaf('x',3), List('e','t','x'), 6)))
  }
  
  test("createCodeTree of some tree") {
    assert(createCodeTree(string2Chars("texxtx")) == Fork(Fork(Leaf('e',1), Leaf('t',2), List('e', 't'), 3), Leaf('x',3), List('e','t','x'), 6))
  }
  
  test("validate given trees") {
    new TestTrees {
	    assert(createCodeTree(string2Chars("abbab")) == t1)
    }
  }
  
  //test("full test of the code tree creator") {
    //val tree = createCodeTree(string2Chars("AAAAAAAABBBCDEFGH"))
    //assert(decode(tree, List(1,0,0,0,1,0,1,0)) == "BAC")
  //}
  
  test("decode french secret") {
    assert(decodedSecret == List('h', 'u', 'f', 'f', 'm', 'a', 'n', 'e', 's', 't', 'c', 'o', 'o', 'l'))
  }
  
  test("encode french secret") {
    assert(encodeSecret == List(0,0,1,1,1,0,1,0,1,1,1,0,0,1,1,0,1,0,0,1,1,0,1,0,1,1,0,0,1,1,1,1,1,0,1,0,1,1,0,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,0,0,1,0,0,0,1,0,1))
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
  
  test("quick encode french secret") {
    assert(quickEncodeSecret == List(0,0,1,1,1,0,1,0,1,1,1,0,0,1,1,0,1,0,0,1,1,0,1,0,1,1,0,0,1,1,1,1,1,0,1,0,1,1,0,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,0,0,1,0,0,0,1,0,1))
  }
}
