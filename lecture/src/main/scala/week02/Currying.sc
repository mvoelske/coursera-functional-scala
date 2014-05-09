package funsets

object Currying {

  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int

  def sumSquares = sum(x => x * x)                //> sumSquares: => (Int, Int) => Int

  sumSquares(1, 10)                               //> res0: Int = 385

  // alternative syntax for functions returning functions:
  def sum2(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum2(f)(a + 1, b)    //> sum2: (f: Int => Int)(a: Int, b: Int)Int

  sum2(x => x * x)(1, 10)                         //> res1: Int = 385

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 else f(a) * product(f)(a + 1, b) //> product: (f: Int => Int)(a: Int, b: Int)Int

  def factorial(n: Int) = product(x => x) (1, n)  //> factorial: (n: Int)Int
  factorial(5)                                    //> res2: Int = 120


	// generalizing sum & product:
  def mapReduce(combine: (Int, Int) => Int, unit: Int)(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) unit else combine(f(a), mapReduce(combine, unit)(f)(a + 1, b))
                                                  //> mapReduce: (combine: (Int, Int) => Int, unit: Int)(f: Int => Int)(a: Int, b:
                                                  //|  Int)Int
 
 	def product2 = mapReduce(_ * _, 1) _      //> product2: => (Int => Int) => ((Int, Int) => Int)
            
	def factorial2(n: Int) = product2(x => x)(1, n)
                                                  //> factorial2: (n: Int)Int
	
	factorial2(5)                             //> res3: Int = 120
}