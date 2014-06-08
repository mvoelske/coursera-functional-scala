package week06

object poly {

  class Poly(terms0: Map[Int, Double]) {

    def this(bindings: (Int, Double)*) = this(bindings.toMap)

    val terms = terms0 withDefaultValue (0.0)
    def +(other: Poly) = new Poly(terms ++ (other.terms map adjust))

    def /+(other: Poly) =
      new Poly((other.terms foldLeft terms)(addTerm))

    def addTerm(terms: Map[Int, Double], term: (Int, Double)) =
      terms.get(term._1) match {
        case Some(coeff) => terms + (term._1 -> (coeff + term._2))
        case None => terms + term
      }

    def adjust(term: (Int, Double)): (Int, Double) = {
      val (exp, coeff) = term
      exp -> (coeff + terms(exp))
    }

    override def toString =
      (for ((exp, coeff) <- terms.toList.sorted.reverse)
        yield coeff + "x^" + exp) mkString " + "
  }

  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2) //> p1  : week06.poly.Poly = 6.2x^5 + 4.0x^3 + 2.0x^1
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))      //> p2  : week06.poly.Poly = 7.0x^3 + 3.0x^0

  p1 + p2                                         //> res0: week06.poly.Poly = 6.2x^5 + 11.0x^3 + 2.0x^1 + 3.0x^0
  p1 /+ p2                                        //> res1: week06.poly.Poly = 6.2x^5 + 11.0x^3 + 2.0x^1 + 3.0x^0
}