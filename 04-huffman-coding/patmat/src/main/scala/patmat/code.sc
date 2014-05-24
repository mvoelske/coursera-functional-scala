package patmat

object code {

	Huffman.decodedSecret                     //> res0: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
	
	
	val qcoded = Huffman.quickEncode(
		Huffman.frenchCode)(
		Huffman.string2Chars("huffmanestcool"))
                                                  //> qcoded  : List[patmat.Huffman.Bit] = List(0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0
                                                  //| , 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1,
                                                  //|  1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 
                                                  //| 1)
            
 Huffman.decode(Huffman.frenchCode, qcoded)       //> res1: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)


}