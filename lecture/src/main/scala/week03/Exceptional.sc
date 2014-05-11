package week03

object Exceptional {

  def error(msg: String) = throw new Error(msg)   //> error: (msg: String)Nothing

  classOf[Null]                                   //> res0: Class[Null](classOf[scala.Null]) = class scala.runtime.Null$

	if (true) 1 else false                    //> res1: AnyVal = 1
}