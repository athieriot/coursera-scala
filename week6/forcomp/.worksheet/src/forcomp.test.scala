package forcomp

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(74); 
  println("Welcome to the Scala worksheet");$skip(41); 
  
  val abba = List(('a', 2), ('b', 3));System.out.println("""abba  : List[(Char, Int)] = """ + $show(abba ));$skip(164); 
  
  def test(occurrences: List[(Char, Int)]) =
  	for {
          p <- occurrences
          i <- 1 until p._2 + 1
        } yield {
          (p._1, i)
        };System.out.println("""test: (occurrences: List[(Char, Int)])List[(Char, Int)]""");$skip(50); val res$0 = 
                                    
  test(abba);System.out.println("""res0: List[(Char, Int)] = """ + $show(res$0));$skip(43); val res$1 = 
  
  for (c <- test(abba)) yield {List(c)};System.out.println("""res1: List[List[(Char, Int)]] = """ + $show(res$1))}
}
