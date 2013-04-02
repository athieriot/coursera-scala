
object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(39); 
  val x = Rational(1, 2);System.out.println("""x  : <error> = """ + $show(x ));$skip(10); val res$0 = 
  x.numer;System.out.println("""res0: <error> = """ + $show(res$0));$skip(10); val res$1 = 
  x.denom;System.out.println("""res1: <error> = """ + $show(res$1))}
}

class Rational(x: Int, y: Int) {
	def numer = x
	def denom = y
	
	
	
	override def toString = numer + "/" + denom
}
