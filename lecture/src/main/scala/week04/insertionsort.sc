package week04

object insertionsort {

	def sort(xs: List[Int]): List[Int] = xs match {
		case List() => List()
		case y :: ys => insert(y, sort(ys))
	}                                         //> sort: (xs: List[Int])List[Int]

	def insert(x: Int, xs: List[Int]): List[Int] = xs match {
		case List() => x :: Nil
		case y :: ys => if (x <= y) x :: y :: ys else y :: insert(x, ys)
	}                                         //> insert: (x: Int, xs: List[Int])List[Int]

  sort(List(6,2,4,1,7))                           //> res0: List[Int] = List(1, 2, 4, 6, 7)
  
}