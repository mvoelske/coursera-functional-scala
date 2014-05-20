package week04

object bounds {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def foo[S >: NonEmpty <: IntSet](xs: S) = ???   //> foo: [S >: week04.NonEmpty <: week04.IntSet](xs: S)Nothing
  
  val a : Array[NonEmpty] = Array(new NonEmpty()) //> a  : Array[week04.NonEmpty] = Array(week04.NonEmpty@625a80df)
	//val b : Array[IntSet] = a // error! Arrays are invariant
	
	
	// due to the type bounds on prepend, f automatically gets
	// the correct type, List[IntSet]
	def f(xs: List[NonEmpty], x: Empty) = xs prepend x
                                                  //> f: (xs: week04.List[week04.NonEmpty], x: week04.Empty)week04.List[week04.Int
                                                  //| Set]
}

trait IntSet

class Empty extends IntSet
class NonEmpty extends IntSet