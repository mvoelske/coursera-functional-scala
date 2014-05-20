package week04

object decom {

  /*
  def eval(e: dumb.Expr): Int = {
    if (e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("Unknown expression " + e)
  }
  */

  import smart._
  def eval(e: smart.Expr): Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
  }                                               //> eval: (e: week04.smart.Expr)Int

  def show_as_prod_operand(e: Expr) = e match {
    case Sum(_, _) => "(" + show(e) + ")"
    case _ => show(e)
  }                                               //> show_as_prod_operand: (e: week04.smart.Expr)String

  def show(e: Expr): String = e match {
    case Number(n) => n.toString
    case Var(x) => x
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => show_as_prod_operand(e1) + " * " + show_as_prod_operand(e2)
  }                                               //> show: (e: week04.smart.Expr)String

  show(Prod(Prod(Number(3), Number(9)), Sum(Sum(Var("x"), Var("y")), Number(3))))
                                                  //> res0: String = 3 * 9 * (x + y + 3)

}

package smart {
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Var(name: String) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr
}

package dumb {

  trait Expr {
    def isNumber: Boolean
    def isSum: Boolean
    def numValue: Int
    def leftOp: Expr
    def rightOp: Expr
  }

  class Number(n: Int) extends Expr {
    def isNumber: Boolean = true
    def isSum: Boolean = false
    def numValue: Int = n
    def leftOp: Expr = throw new Error("Number.leftOp")
    def rightOp: Expr = throw new Error("Number.rightOp")
  }

  class Sum(e1: Expr, e2: Expr) extends Expr {
    def isNumber = false
    def isSum = true
    def numValue = throw new Error("Sum.numValue")
    def leftOp = e1
    def rightOp = e2
  }
}