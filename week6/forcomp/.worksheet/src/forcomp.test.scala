package forcomp

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(74); 
  println("Welcome to the Scala worksheet")
  type Occurrences = List[(Char, Int)];$skip(80); 
  
  val abba = List(('a', 2), ('b', 2));System.out.println("""abba  : List[(Char, Int)] = """ + $show(abba ));$skip(188); 

   
        def allOccurences(p: (Char, Int)): Seq[(Char, Int)] = {
          for {
            i: Int <- 0 until p._2 + 1
          } yield {
            (p._1, i)
          }
        };System.out.println("""allOccurences: (p: (Char, Int))Seq[(Char, Int)]""");$skip(104); 
        
        val everything = for{
          p <- abba
        } yield {
          allOccurences(p)
        };System.out.println("""everything  : List[Seq[(Char, Int)]] = """ + $show(everything ));$skip(237); 
   
   def cartesianProduct(xss: List[Seq[(Char, Int)]]): Seq[Seq[(Char, Int)]] = xss match {
    case Nil => List(Nil)
    case h :: t => {
    	for {
    	xh <- h
    	xt <- cartesianProduct(t)
    	} yield xh +: xt
   }
  };System.out.println("""cartesianProduct: (xss: List[Seq[(Char, Int)]])Seq[Seq[(Char, Int)]]""");$skip(89); 
     
   val test = cartesianProduct(everything).map(p => {
   p.filter(_._2 != 0)
   });System.out.println("""test  : Seq[Seq[(Char, Int)]] = """ + $show(test ));$skip(18); val res$0 = 
   
  test.length;System.out.println("""res0: Int = """ + $show(res$0))}
}
