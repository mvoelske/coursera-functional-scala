package patmat

object code {

  Huffman.decodedSecret                           //> res0: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)

  val qcoded = Huffman.quickEncode(
    Huffman.frenchCode)(
      Huffman.string2Chars("huffmanestcool"))     //> qcoded  : List[patmat.Huffman.Bit] = List(0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0
                                                  //| , 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1,
                                                  //|  1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 
                                                  //| 1)

  Huffman.decode(Huffman.frenchCode, qcoded)      //> res1: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)

  val lf = List(('e', 225947), ('s', 121895), ('a', 117110), ('i', 115465), ('t', 111103), ('n', 108812), ('r', 100500), ('u', 96785), ('l', 83668), ('o', 82762), ('d', 56269), ('c', 50003), ('p', 46335), ('m', 45521), ('v', 24975), ('q', 20889), ('f', 16351), ('b', 13822), ('g', 13288), ('h', 11298), ('j', 8351), ('x', 5928), ('y', 4725), ('z', 2093), ('w', 1747), ('k', 745))
                                                  //> lf  : List[(Char, Int)] = List((e,225947), (s,121895), (a,117110), (i,115465
                                                  //| ), (t,111103), (n,108812), (r,100500), (u,96785), (l,83668), (o,82762), (d,5
                                                  //| 6269), (c,50003), (p,46335), (m,45521), (v,24975), (q,20889), (f,16351), (b,
                                                  //| 13822), (g,13288), (h,11298), (j,8351), (x,5928), (y,4725), (z,2093), (w,174
                                                  //| 7), (k,745))

  Huffman.chars(Huffman.frenchCode).size          //> res2: Int = 26

	lf.size                                   //> res3: Int = 26
	
	Huffman.weight(Huffman.frenchCode)        //> res4: Int = 1486387

	lf.map(_._2).sum                          //> res5: Int = 1486387
}