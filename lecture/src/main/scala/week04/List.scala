package week04

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  
  override def toString : String = 
    if (isEmpty) "()"
    else "(" + head.toString + ", " + tail.toString + ")"
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

object List {
  def apply[T]() = new Nil[T]
  def apply[T](x: T) = new Cons[T](x, new Nil[T])
  def apply[T](x: T, y: T) = new Cons[T](x, new Cons[T](y, new Nil[T]))
}