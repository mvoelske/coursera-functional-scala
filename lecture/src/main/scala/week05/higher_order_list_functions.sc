package week05

object higher_order_list_functions {

  def squareListPm(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case y :: ys => y * y :: squareListPm(ys)
  }                                               //> squareListPm: (xs: List[Int])List[Int]

  def squareListMap(xs: List[Int]) = xs map (x => x * x)
                                                  //> squareListMap: (xs: List[Int])List[Int]

  squareListMap(List(1, 2, 3, 4))                 //> res0: List[Int] = List(1, 4, 9, 16)
  squareListPm(List(1, 2, 3, 4))                  //> res1: List[Int] = List(1, 4, 9, 16)

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 => pack(xs1) match {
      case Nil => List(List(x))
      case (y :: ys) :: zs => if (x == y) (x :: y :: ys) :: zs
      else List(x) :: (y :: ys) :: zs
    }
  }                                               //> pack: [T](xs: List[T])List[List[T]]

  def pack2[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (head, tail) = xs1 span (y => y == x)
      (x :: head) :: pack2(tail)
  }                                               //> pack2: [T](xs: List[T])List[List[T]]
  pack2(List("a", "a", "a", "b", "c", "c", "a"))  //> res2: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a))
                                                  //| 

  def encode[T](xs: List[T]): List[(T, Int)] = pack(xs).map(x => (x.head, x.size))
                                                  //> encode: [T](xs: List[T])List[(T, Int)]

  encode(List("a", "a", "a", "b", "c", "c", "a")) //> res3: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))

  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight (List[U]()))(f(_) :: _)         //> mapFun: [T, U](xs: List[T], f: T => U)List[U]

  mapFun(List(1, 2, 3, 4), (x: Int) => (x + 1) + "!")
                                                  //> res4: List[String] = List(2!, 3!, 4!, 5!)

	def lengthFun[T](xs: List[T]): Int =
		(xs foldRight 0)( (x, c) => c + 1 )
                                                  //> lengthFun: [T](xs: List[T])Int
  lengthFun( (1 to 12).toList )                   //> res5: Int = 12
}