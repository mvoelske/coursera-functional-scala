package week06

object fortranslate {
	case class Book(title: String, authors: List[String])
	val books = List(
	Book("The Book of Foo", List("Foo, Jimmy")),
	Book("Birds.", List("Bird, Big")),
	Book("More Birds.", List("Bird, Small"))) //> books  : List[week06.fortranslate.Book] = List(Book(The Book of Foo,List(Foo
                                                  //| , Jimmy)), Book(Birds.,List(Bird, Big)), Book(More Birds.,List(Bird, Small))
                                                  //| )
	
	for(b <- books; a <- b.authors if a startsWith "Bird")
	yield b.title                             //> res0: List[String] = List(Birds., More Birds.)
	
	
	books flatMap (b => for(a <- b.authors if a startsWith("Bird")) yield b.title)
                                                  //> res1: List[String] = List(Birds., More Birds.)
 
 
 	books flatMap (b => b.authors.withFilter(_.startsWith("Bird")).map( y => b.title ))
                                                  //> res2: List[String] = List(Birds., More Birds.)
 
  books withFilter(b => b.authors.exists(a => a.startsWith("Bird"))) map(b => b.title)
                                                  //> res3: List[String] = List(Birds., More Birds.)
}