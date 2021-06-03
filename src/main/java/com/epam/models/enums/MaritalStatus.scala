package com.epam.models.enums

object MaritalStatus extends Enumeration {
  type MaritalStatus = Value
  val Single, Married, Divorced = Value

  def parse(name: String): Value = values.find(_.toString.toLowerCase() == name.toLowerCase()).getOrElse(throw new RuntimeException(s"Error parsing $name to narital status."))
  def parseToOption(name: String) = values.find(_.toString.toLowerCase() == name.toLowerCase())

  implicit class StringExt_MaritalStatus(string: String) {
    def isValidMaritalStatus: Boolean = MaritalStatus.parseToOption(string).isDefined;
  }
}
