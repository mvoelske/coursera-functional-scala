package week05

object lists {

	val l = (1 to 12).toList                  //> l  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
	
	l.updated(5, 99)                          //> res0: List[Int] = List(1, 2, 3, 4, 5, 99, 7, 8, 9, 10, 11, 12)
	
	def init[T](xs: List[T]): List[T] = xs match {
		case List() => throw new Error("init of empty list")
		case List(x) => List()
		case y :: ys => y :: init(ys)
	}                                         //> init: [T](xs: List[T])List[T]
	
	init(l)                                   //> res1: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
	
	def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
		case List() => ys
		case x :: xs => x :: concat(xs, ys)
	}                                         //> concat: [T](xs: List[T], ys: List[T])List[T]
	
	concat(List(1,2,3), List("a", "b", "c"))  //> res2: List[Any] = List(1, 2, 3, a, b, c)
	
	
	def removeAt[T](n: Int, xs: List[T]): List[T] = (n, xs) match {
		case (0, x :: xs) => xs
		case (i, x :: xs) => x :: removeAt(i - 1, xs)
	}                                         //> removeAt: [T](n: Int, xs: List[T])List[T]
	
	assert(removeAt(1, List(1,2,3)) == List(1,3))
	
	def flatten(xs: List[Any]): List[Any] = xs match {
	  case List() => List()
		case (x::xs)::rest => flatten(x::xs) ++ flatten(rest)
		case x::xs => x::flatten(xs)
	}                                         //> flatten: (xs: List[Any])List[Any]
	
	flatten(List(List(1,1), 2, List(3, List(5, 8)), List(2, 5), 43))
                                                  //> res3: List[Any] = List(1, 1, 2, 3, 5, 8, 2, 5, 43)
	
}