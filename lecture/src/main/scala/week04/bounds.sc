package week04

object bounds {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def foo[S >: NonEmpty <: IntSet](xs: S) = ???   //> foo: [S >: week04.NonEmpty <: week04.IntSet](xs: S)Nothing
  
  val a : Array[NonEmpty] = Array(new NonEmpty()) //> a  : Array[week04.NonEmpty] = Array(week04.NonEmpty@299bc338)
	//val b : Array[IntSet] = a // error! Arrays are invariant
}

trait IntSet

class Empty extends IntSet
class NonEmpty extends IntSet