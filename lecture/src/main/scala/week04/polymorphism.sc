package week04

object polymorphism {

  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
                                                  //> singleton: [T](elem: T)week04.Cons[T]

  // type parameters are inferred:
  val l = singleton(1)                            //> l  : week04.Cons[Int] = week04.Cons@2521ddb8
  val l1 = singleton("Foobar")                    //> l1  : week04.Cons[String] = week04.Cons@52636e13

  def nth[T](n: Int, l: List[T]): T =
    if (l.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) l.head
    else nth(n - 1, l.tail)                       //> nth: [T](n: Int, l: week04.List[T])T

  val testList = new Cons(4, new Cons(5, new Cons(6, new Nil)))
                                                  //> testList  : week04.Cons[Int] = week04.Cons@7dcfcba6
  nth(0, testList)                                //> res0: Int = 4
  nth(1, testList)                                //> res1: Int = 5
  nth(2, testList)                                //> res2: Int = 6

}

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

// the constructor parameters head & tail count as implementations of the abstract trait methods!
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}