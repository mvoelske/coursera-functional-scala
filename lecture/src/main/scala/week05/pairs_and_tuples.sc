package week05

object pairs_and_tuples {

  val pair = ("answer", 42)                       //> pair  : (String, Int) = (answer,42)
  val (label, value) = pair                       //> label  : String = answer
                                                  //| value  : Int = 42

  def merge(xs: List[Int], ys: List[Int]): List[Int] =
    (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (x < y) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }                                             //> merge: (xs: List[Int], ys: List[Int])List[Int]

  merge(List(10, 20, 30, 40), List(9, 19, 21, 29, 31))
                                                  //> res0: List[Int] = List(9, 10, 19, 20, 21, 29, 30, 31, 40)

}