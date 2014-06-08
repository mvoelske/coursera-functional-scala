package week06

object combinations {

  val M = 5                                       //> M  : Int = 5
  val N = 3                                       //> N  : Int = 3

  (1 to M) flatMap (x => (1 to N) map (y => (x, y)))
                                                  //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1,2
                                                  //| ), (1,3), (2,1), (2,2), (2,3), (3,1), (3,2), (3,3), (4,1), (4,2), (4,3), (5,
                                                  //| 1), (5,2), (5,3))

  def isPrime(n: Int): Boolean = (2 until n) map (x => n % x) forall (_ != 0)
                                                  //> isPrime: (n: Int)Boolean

	isPrime(17)                               //> res1: Boolean = true
}