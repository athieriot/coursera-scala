package forcomp

import common._

object test {
  //val sentence = List("Linux", "rulez")
  
  val list = List("Linux", "rulez")               //> list  : List[String] = List(Linux, rulez)
  
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
	}                                         //> subAnagrams: (oc: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Sentenc
                                                  //| e]
	
	subAnagrams(Anagrams.sentenceOccurrences(list))
                                                  //> res0: List[forcomp.Anagrams.Sentence] = List(List(Zulu, Lin, Rex), List(Zulu
                                                  //| , nil, Rex), List(Zulu, Rex, Lin), List(Zulu, Rex, nil), List(null, Uzi, Rex
                                                  //| ), List(null, Rex, Uzi), List(Uzi, null, Rex), List(Uzi, Rex, null), List(Li
                                                  //| n, Zulu, Rex), List(Lin, Rex, Zulu), List(nil, Zulu, Rex), List(nil, Rex, Zu
                                                  //| lu), List(Linux, rulez), List(Rex, Zulu, Lin), List(Rex, Zulu, nil), List(Re
                                                  //| x, null, Uzi), List(Rex, Uzi, null), List(Rex, Lin, Zulu), List(Rex, nil, Zu
                                                  //| lu), List(rulez, Linux))
}