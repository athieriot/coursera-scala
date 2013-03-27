package recfun

object plop {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def count(money: Int, coins: List[Int]): Boolean = {
      if (money == 0) true
      else if (money != 0 && coins.isEmpty) false
      else {
        if ((money / coins.head) >= 1) count(money - coins.head, coins)
        else count(money, coins.tail)
      }
    }                                             //> count: (money: Int, coins: List[Int])Boolean
    
    count(300,List(5,10,20,50,100,200,500))       //> res0: Boolean = true
    
}