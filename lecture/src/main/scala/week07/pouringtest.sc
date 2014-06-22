package week07

object pouringtest {

	val problem = new Pouring(Vector(4, 7, 19))
                                                  //> problem  : week07.Pouring = week07.Pouring@391fc13d
	problem.moves                             //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with we
                                                  //| ek07.pouringtest.problem.Move] = Vector(Empty(0), Empty(1), Empty(2), Fill(0)
                                                  //| , Fill(1), Fill(2), Pour(0,1), Pour(0,2), Pour(1,0), Pour(1,2), Pour(2,0), Po
                                                  //| ur(2,1))
	
	
	problem.solutions(13)                     //> res1: Stream[week07.pouringtest.problem.Path] = Stream(Fill(2) Pour(2,1) Fil
                                                  //| l(0) Pour(0,2) Empty(1) Pour(2,1) Pour(1,0) Pour(0,2)-->Vector(0, 3, 13), ?)
                                                  //| 
	
}