package forcomp

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  type Occurrences = List[(Char, Int)]
  
  val abba = List(('a', 2), ('b', 2))             //> abba  : List[(Char, Int)] = List((a,2), (b,2))

   
        def allOccurences(p: (Char, Int)): Seq[(Char, Int)] = {
          for {
            i: Int <- 0 until p._2 + 1
          } yield {
            (p._1, i)
          }
        }                                         //> allOccurences: (p: (Char, Int))Seq[(Char, Int)]
        
        val everything = for{
          p <- abba
        } yield {
          allOccurences(p)                        //> everything  : List[Seq[(Char, Int)]] = List(Vector((a,0), (a,1), (a,2)), Vec
                                                  //| tor((b,0), (b,1), (b,2)))
        }
   
   def cartesianProduct(xss: List[Seq[(Char, Int)]]): Seq[Seq[(Char, Int)]] = xss match {
    case Nil => List(Nil)
    case h :: t => {
    	for {
    	xh <- h
    	xt <- cartesianProduct(t)
    	} yield xh +: xt
   }
  }                                               //> cartesianProduct: (xss: List[Seq[(Char, Int)]])Seq[Seq[(Char, Int)]]
     
   val test = cartesianProduct(everything).map(p => {
   p.filter(_._2 != 0)
   })                                             //> test  : Seq[Seq[(Char, Int)]] = Vector(List(), List((b,1)), List((b,2)), Lis
                                                  //| t((a,1)), List((a,1), (b,1)), List((a,1), (b,2)), List((a,2)), List((a,2), (
                                                  //| b,1)), List((a,2), (b,2)))
   
  test.length                                     //> res0: Int = 9
}