package week2

object rationals {

  val x = new Rational(1, 3)                      //> x  : week2.Rational = 1/3
  x.numer                                         //> res0: Int = 1

  val y = new Rational(5, 7)                      //> y  : week2.Rational = 5/7
  x.add(y)                                        //> res1: week2.Rational = 22/21

  val z = new Rational(3, 2)                      //> z  : week2.Rational = 3/2
  x.neg                                           //> res2: week2.Rational = 1/-3
  x.sub(y)                                        //> res3: week2.Rational = 8/-21

  x.sub(y).sub(z)                                 //> res4: week2.Rational = -79/42
  x.less(y)                                       //> res5: Boolean = true
  x.max(y)                                        //> res6: week2.Rational = 5/7

  new Rational(2)                                 //> res7: week2.Rational = 2/1

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