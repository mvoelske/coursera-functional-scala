package funsets

object FixedPoints {
  import math.abs

  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4

  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance              //> isCloseEnough: (x: Double, y: Double)Boolean

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double

	fixedPoint(x => 1 + x/2)(1)               //> res0: Double = 1.999755859375
	
	def sqrt(x : Double) = fixedPoint(y => (y + x/y)/2)(1)
                                                  //> sqrt: (x: Double)Double
	sqrt(100)                                 //> res1: Double = 10.000000000139897
	
	
	def averageDamp(f : Double => Double)(x : Double) = (x + f(x)) / 2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
                                                  
	def sqrt2(x : Double) = fixedPoint(averageDamp(y => x / y))(1)
                                                  //> sqrt2: (x: Double)Double
	
	sqrt2(100)                                //> res2: Double = 10.000000000139897
	
	fixedPoint(averageDamp(x => 4 / (7 + x * x)))(123)
                                                  //> res3: Double = 0.5479524604639487
}