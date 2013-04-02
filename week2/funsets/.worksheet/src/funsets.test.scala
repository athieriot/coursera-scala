package funsets

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(59); 
  val x = new Rational(1, 3);System.out.println("""x  : funsets.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : funsets.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : funsets.Rational = """ + $show(z ));$skip(18); val res$0 = 
  x.sub(y).sub(z);System.out.println("""res0: funsets.Rational = """ + $show(res$0));$skip(14); val res$1 = 
  
  y.add(y);System.out.println("""res1: funsets.Rational = """ + $show(res$1));$skip(48); 
  
  val u = new Rational(988546545, 795645688);System.out.println("""u  : funsets.Rational = """ + $show(u ));$skip(16); val res$2 = 
  
  u.toString;System.out.println("""res2: String = """ + $show(res$2))}
}

class Rational(x: Int, y: Int) {
	private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
	private val g = gcd(x, y)

	val numer = x
	val denum = y
	
	def add(that: Rational) = {
		new Rational(
		  numer * that.denum + that.numer * denum,
		  denum * that.denum)
	}
	
	def neg: Rational = new Rational(-numer, denum)
	
	def sub(that: Rational) = add(that.neg)
	
	override def toString = numer/g + "/" + denum/g
}
