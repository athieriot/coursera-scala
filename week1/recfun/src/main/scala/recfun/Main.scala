package recfun
import common._
import java.security.InvalidParameterException

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (r < 0 || c < 0 || c > r) throw new InvalidParameterException  
    
    if (r == 0 || c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def count(close: Boolean, acc: Int, chars: List[Char]): Boolean = chars match {
      case Nil => close && acc == 0
      case head :: tail if head == '(' => count(false, acc + 1, tail)
      case head :: tail if head == ')' => count(true, acc - 1, tail)
	  case _ :: tail => count(close, acc, tail)
    }
    
    count(true, 0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    def accumulate(acc: Int, money: Int, coins: List[Int]): Int = coins match {
      case Nil => acc
      case _ if money < 0 => acc
      case _ if money == 0 => acc + 1
	  case _ => accumulate(0, money, coins.tail) + accumulate(0, money - coins.head, coins)
    }
    
    if (money == 0) 0
    else accumulate(0, money, coins.sorted)
  }
}
