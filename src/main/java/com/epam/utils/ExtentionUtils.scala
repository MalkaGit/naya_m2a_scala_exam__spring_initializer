package com.epam.utils

object ExtentionUtils {

  implicit class ObjectExt(obj: Object){
    def toJson: String = JsonSerializerUtil.serialize(obj)
  }

  implicit class StringExt(string: String) {
    private val emailRegex = """^[a-zA-Z0-9\.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$""".r

    def isValidAge: Boolean = {
      val tmp: Int = string.toIntOption.getOrElse(-1)
      return tmp >0 && tmp <= 120;
    }
    def isValidNumberOfChildren: Boolean = {
      val tmp: Int = string.toIntOption.getOrElse(-1)
      return tmp >0 && tmp <= 20;
    }
    def isValidEmail: Boolean = string match {
      case null => false
      case string if string.trim.isEmpty => false
      case string if emailRegex.findFirstMatchIn(string).isDefined  => true
      case _ => false
    }
    def isValidPhone: Boolean = string.length > 8;
  }

  implicit class IntExt(number: Int) {
    def isPositive: Boolean = (number > 0);
   }

}
