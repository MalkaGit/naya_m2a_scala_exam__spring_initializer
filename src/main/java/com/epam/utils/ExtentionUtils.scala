package com.epam.utils

object ExtentionUtils {

  implicit class ObjectExt(obj: Object){
    def toJson: String = JsonSerializerUtil.serialize(obj)
  }

  implicit class StringExt(string: String) {

    def isValidAge: Boolean = {
      val tmp: Int = string.toIntOption.getOrElse(-1)
      return tmp >0 && tmp <= 120;
    }
    def isValidNumberOfChildren: Boolean = {
      val tmp: Int = string.toIntOption.getOrElse(-1)
      return tmp >0 && tmp <= 20;
    }
    def isValidEmail: Boolean = string.contains("@");
    def isValidPhone: Boolean = string.length > 8;
  }

  implicit class IntExt(number: Int) {
    def isPositive: Boolean = (number > 0);
   }

}
