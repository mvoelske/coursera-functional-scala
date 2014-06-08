package week06

object scalarprod {

  def scalarProduct(xs: List[Double], ys: List[Double]): Double = {
    (for {
      (x, y) <- xs zip ys
    } yield x * y).sum
  }                                               //> scalarProduct: (xs: List[Double], ys: List[Double])Double

  scalarProduct(
    List(1, 3, 4),
    List(2, 3, 4))                                //> res0: Double = 27.0
}