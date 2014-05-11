package week04

object Intsets {

  val t1 = new NonEmpty(3, Empty, Empty)          //> t1  : week04.NonEmpty = {.3.}

  val t2 = t1 incl 5                              //> t2  : week04.IntSet = {.3{.5.}}

  val t3 = t2 incl -5 incl 7 incl -43             //> t3  : week04.IntSet = {{{.-43.}-5.}3{.5{.7.}}}

	t2 union (Empty incl 4)                   //> res0: week04.IntSet = {{.3.}4{.5.}}
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  override def contains(x: Int): Boolean = false
  override def incl(x: Int): IntSet = new NonEmpty(x, Empty,
    Empty)
  override def union(other: IntSet) = other
  override def toString = "."
}

class NonEmpty(elem: Int,
  left: IntSet,
  right: IntSet) extends IntSet {

  override def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  override def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
    
  override def union(other: IntSet): IntSet =
  	((left union right) union other) incl elem

  override def toString = "{" + left + elem + right + "}"
}