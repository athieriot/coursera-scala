package recfun

object plop {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  println("Welcome to the Scala worksheet");$skip(272); 
  
  def count(money: Int, coins: List[Int]): Boolean = {
      if (money == 0) true
      else if (money != 0 && coins.isEmpty) false
      else {
        if ((money / coins.head) >= 1) count(money - coins.head, coins)
        else count(money, coins.tail)
      }
    };System.out.println("""count: (money: Int, coins: List[Int])Boolean""");$skip(49); val res$0 = 
    
    count(300,List(5,10,20,50,100,200,500));System.out.println("""res0: Boolean = """ + $show(res$0))}
    
}
