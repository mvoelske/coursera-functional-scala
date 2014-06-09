package week07

object stream {

	def streamRange(lo: Int, hi: Int): Stream[Int] =
		if (lo >= hi) Stream.empty
		else {
		println(s"LO:$lo HI:$hi")
		Stream.cons(lo, streamRange(lo + 1, hi))
		}                                 //> streamRange: (lo: Int, hi: Int)Stream[Int]


	val sr = streamRange(1, 100)              //> LO:1 HI:100
                                                  //| sr  : Stream[Int] = Stream(1, ?)
       
  sr.tail.tail.tail                               //> LO:2 HI:100
                                                  //| LO:3 HI:100
                                                  //| LO:4 HI:100
                                                  //| res0: scala.collection.immutable.Stream[Int] = Stream(4, ?)
}