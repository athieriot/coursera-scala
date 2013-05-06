package forcomp

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val abba = List(('a', 2), ('b', 3))             //> abba  : List[(Char, Int)] = List((a,2), (b,3))
  
  def test(occurrences: List[(Char, Int)]) =
  	for {
          p <- occurrences
          i <- 1 until p._2 + 1
        } yield {
          (p._1, i)
        }                                         //> test: (occurrences: List[(Char, Int)])List[(Char, Int)]
                                    
  test(abba)                                      //> res0: List[(Char, Int)] = List((a,1), (a,2), (b,1), (b,2), (b,3))
  
  for (c <- test(abba)) yield {List(c)}           //> res1: List[List[(Char, Int)]] = List(List((a,1)), List((a,2)), List((b,1)), 
                                                  //| List((b,2)), List((b,3)))
}