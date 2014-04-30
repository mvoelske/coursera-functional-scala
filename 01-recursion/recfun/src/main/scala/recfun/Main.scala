package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = (c, r) match {
    case (0, r) => 1
    case (c, r) if c == r => 1
    case (c, r) => pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def balanceHelper(l : List[Char], stack : Int): Boolean = (l, stack) match {
      case (Nil, 0) => true
      case (Nil, _) => false
      case ('(' :: xs, s) => balanceHelper(xs, s + 1)
      case (')' :: xs, 0) => false
      case (')' :: xs, s) => balanceHelper(xs, s - 1)
      case (x :: xs, s) => balanceHelper(xs, s)
    }
    balanceHelper(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
