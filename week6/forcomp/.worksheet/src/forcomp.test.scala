package forcomp

import common._

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(128); 
  //val sentence = List("Linux", "rulez")
  
  val list = List("Linux", "rulez");System.out.println("""list  : List[String] = """ + $show(list ));$skip(367); 
  
	def subAnagrams(oc: Anagrams.Occurrences) : List[Anagrams.Sentence] = oc match {
	  case Nil => List(Nil)
	  case l => {
	    for {
	      combi <- Anagrams.combinations(l)
	      w <- Anagrams.dictionaryByOccurrences.apply(combi)
	      sent <- subAnagrams(Anagrams.subtract(l, Anagrams.wordOccurrences(w)).sorted)
	    } yield {
	      w :: sent
	    }
	  }
	};System.out.println("""subAnagrams: (oc: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Sentence]""");$skip(51); val res$0 = 
	
	subAnagrams(Anagrams.sentenceOccurrences(list));System.out.println("""res0: List[forcomp.Anagrams.Sentence] = """ + $show(res$0))}
}
