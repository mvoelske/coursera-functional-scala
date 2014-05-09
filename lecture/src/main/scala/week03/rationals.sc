package week03

object rationals {

  val x = new Rational(1, 3)                      //> x  : week03.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : week03.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : week03.Rational = 3/2

  x - y - z                                       //> res0: week03.Rational = -79/42
  y + y                                           //> res1: week03.Rational = 10/7

  x < y                                           //> res2: Boolean = true

  x max y                                         //> res3: week03.Rational = 5/7
  
  -x                                              //> res4: week03.Rational = 1/-3
}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  val numer = x / g
  val denom = y / g

  def less(that: Rational) = numer * that.denom < that.numer * denom

  def <(that: Rational) = less(that)

  def max(that: Rational) = if (this less that) that else this

  def +(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  def unary_- = new Rational(-numer, denom)

  def -(that: Rational) = this + (-that)

  override def toString = numer + "/" + denom
}