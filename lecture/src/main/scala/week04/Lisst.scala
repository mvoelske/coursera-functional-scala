package week04

trait Lisst[+T] { // "+T" -> List is covariant w.r.t. T 
  // i.e., List of X is a subtype of List of Y iff X is a subtype of Y
  def isEmpty: Boolean
  def head: T
  def tail: Lisst[T]

  // lower bound on the type of elements passed to prepend: 
  // only supertypes of T are allowed. This enforces the Liskov
  // substitution principle: if we want to prepend an element that
  // is not of a subtype of T, we must generalize the type of the
  // resulting List (the compiler does this automatically)
  def prepend[U >: T](elem: U): Lisst[U] = new Cons(elem, this)
  
  override def toString: String =
    if (isEmpty) "()"
    else "(" + head.toString + ", " + tail.toString + ")"
}

// the constructor parameters head & tail count as implementations of the abstract trait methods!
class Cons[T](val head: T, val tail: Lisst[T]) extends Lisst[T] {
  def isEmpty = false
}

object Nill extends Lisst[Nothing] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object Lisst {
  def apply[T]() = Nill
  def apply[T](x: T) = new Cons[T](x, Nill)
  def apply[T](x: T, y: T) = new Cons[T](x, new Cons[T](y, Nill))
}
