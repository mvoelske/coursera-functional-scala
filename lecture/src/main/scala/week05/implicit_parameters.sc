package week05

object implicit_parameters {

	def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
		val n = xs.length / 2
		if (n == 0) xs
		else {
			def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
				case (Nil, ys) => ys
				case (xs, Nil) => xs
				case (x :: xs1, y :: ys1) =>
					if (ord.lt(x,  y)) x :: merge(xs1, ys)
					else y :: merge(xs, ys1)
			}
			val (fst, snd) = xs splitAt n
			merge(msort(fst), msort(snd))
		}
	}                                         //> msort: [T](xs: List[T])(implicit ord: Ordering[T])List[T]


	msort( List(1,23, -2, 9))                 //> res0: List[Int] = List(-2, 1, 9, 23)
	msort( List("foo", "bar", "baz", "quux") )//> res1: List[String] = List(bar, baz, foo, quux)
}