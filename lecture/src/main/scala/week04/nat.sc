package week04

object nat {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  new Succ(Zero)                                  //> res0: week04.Succ = 1
  
  Nat(12) - Nat(10)                               //> res1: week04.Nat = 2
  
  Nat(3) + Nat(4)                                 //> res2: week04.Nat = 7
}

object Nat {
	def apply(v: Int): Nat = if (v > 0) new Succ(apply(v - 1)) else Zero
}

abstract class Nat {
	def isZero: Boolean
	def predecessor: Nat
	def successor = new Succ(this)
	def + (that: Nat): Nat
	def - (that: Nat): Nat
	
	def toInt: Int
	
	override def toString = toInt.toString
}

object Zero extends Nat {
	override def isZero = true
	override def predecessor = throw new Exception("NAAN")
	override def + (that: Nat) = that
	override def - (that: Nat) = if (that.isZero) this else throw new Exception("NAAN")
	
	override def toInt = 0
}

class Succ(n: Nat) extends Nat {
	override def isZero = false
	override def predecessor = n
	override def + (that: Nat) = n + that.successor
	override def - (that: Nat) = if (that.isZero) this else n - that.predecessor
	
	override def toInt = 1 + predecessor.toInt
}