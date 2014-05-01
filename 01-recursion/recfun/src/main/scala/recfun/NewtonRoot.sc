package recfun;

import scala.annotation.tailrec;

object NewtonRoot {

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double): Boolean =
      math.abs(guess * guess - x) / x < 0.0001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }                                               //> sqrt: (x: Double)Double

  sqrt(2)                                         //> res0: Double = 1.4142156862745097
  sqrt(4)                                         //> res1: Double = 2.0000000929222947
  sqrt(1e-6)                                      //> res2: Double = 0.0010000001533016628
  sqrt(1e60)                                      //> res3: Double = 1.0000000031080746E30

  def fact(x: Long) = {
    def factTR(acc: Long, x: Long): Long = {
      if (x == 0) acc
      else factTR(acc * x, x - 1)
    }
    factTR(1, x)
  }                                               //> fact: (x: Long)Long

  fact(8)                                         //> res4: Long = 40320
}