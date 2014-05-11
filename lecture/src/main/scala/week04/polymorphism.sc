package week04

object poly {


}

trait List[T] {
	def isEmpty: Boolean
	def head: T
}

class Cons[T](val head: T, val tail: List[T])