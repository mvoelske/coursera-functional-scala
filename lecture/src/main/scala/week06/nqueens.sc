package week06

object nqueens {

  def isSafe(col: Int, queens: List[Int]): Boolean = {
    val distances = (0 until queens.length) map (queens.length - _)
    val diagonals = for {
      (q, d) <- queens.reverse zip distances
    } yield List(q - d, q + d)
    val threatened = (queens.toSet ++ diagonals.flatten.toSet)
    !threatened.contains(col)
  }                                               //> isSafe: (col: Int, queens: List[Int])Boolean
  
  def isSafe2(col: Int, queens: List[Int]): Boolean = {
  	val row = queens.length
  	val queensWithRow = (row - 1 to 0 by -1) zip queens
  	
  	queensWithRow forall {
  	  case (r, c) => col != c && math.abs(col - c) != row - r
  	}
  }                                               //> isSafe2: (col: Int, queens: List[Int])Boolean
  
  def queens(n: Int): Set[List[Int]] = {

    def placeQueens(k: Int): Set[List[Int]] =
      if (k == 0) Set(List())
      else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe2(col, queens)
        } yield col :: queens
    placeQueens(n)
  }                                               //> queens: (n: Int)Set[List[Int]]


	queens(5)                                 //> res0: Set[List[Int]] = Set(List(0, 3, 1, 4, 2), List(2, 0, 3, 1, 4), List(0,
                                                  //|  2, 4, 1, 3), List(2, 4, 1, 3, 0), List(1, 3, 0, 2, 4), List(3, 0, 2, 4, 1),
                                                  //|  List(4, 2, 0, 3, 1), List(4, 1, 3, 0, 2), List(3, 1, 4, 2, 0), List(1, 4, 2
                                                  //| , 0, 3))
  def show(queens: List[Int]) = {
  	val lines =
  	  for (col <- queens.reverse)
  	  yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
  	"\n" + (lines mkString "\n")
  }                                               //> show: (queens: List[Int])String
  
  (queens(8) take 3 map show) mkString("\n")      //> res1: String = "
                                                  //| * * * * * X * * 
                                                  //| * * * X * * * * 
                                                  //| * X * * * * * * 
                                                  //| * * * * * * * X 
                                                  //| * * * * X * * * 
                                                  //| * * * * * * X * 
                                                  //| X * * * * * * * 
                                                  //| * * X * * * * * 
                                                  //| 
                                                  //| * * * * X * * * 
                                                  //| * * * * * * X * 
                                                  //| * X * * * * * * 
                                                  //| * * * X * * * * 
                                                  //| * * * * * * * X 
                                                  //| X * * * * * * * 
                                                  //| * * X * * * * * 
                                                  //| * * * * * X * * 
                                                  //| 
                                                  //| * * * * * X * * 
                                                  //| * * X * * * * * 
                                                  //| * * * * * * X * 
                                                  //| * * * X * * * * 
                                                  //| X * * * * * * * 
                                                  //| * * * * * * * X 
                                                  //| * X * * * * * * 
                                                  //| * * * * X * * * "
}