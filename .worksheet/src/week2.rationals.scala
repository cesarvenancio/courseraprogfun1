package week2

object rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 

  val x = new Rational(1, 3);System.out.println("""x  : week2.Rational = """ + $show(x ));$skip(10); val res$0 = 
  x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(30); 

  val y = new Rational(5, 7);System.out.println("""y  : week2.Rational = """ + $show(y ));$skip(11); val res$1 = 
  x.add(y);System.out.println("""res1: week2.Rational = """ + $show(res$1));$skip(30); 

  val z = new Rational(3, 2);System.out.println("""z  : week2.Rational = """ + $show(z ));$skip(8); val res$2 = 
  x.neg;System.out.println("""res2: week2.Rational = """ + $show(res$2));$skip(11); val res$3 = 
  x.sub(y);System.out.println("""res3: week2.Rational = """ + $show(res$3));$skip(19); val res$4 = 

  x.sub(y).sub(z);System.out.println("""res4: week2.Rational = """ + $show(res$4));$skip(12); val res$5 = 
  x.less(y);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(11); val res$6 = 
  x.max(y);System.out.println("""res6: week2.Rational = """ + $show(res$6));$skip(19); val res$7 = 

  new Rational(2);System.out.println("""res7: week2.Rational = """ + $show(res$7))}

}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  def numer = x
  def denom = y

  def less(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this.less(that)) that else this

  def neg: Rational = new Rational(-numer, denom)

  def add(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  def sub(that: Rational) = add(that.neg)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def toString = {
    val g = gcd(this.numer, this.denom)
    numer / g + "/" + denom / g
  }

}
