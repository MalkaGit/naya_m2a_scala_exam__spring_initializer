package com.epam.models.enums

object Gender extends Enumeration {
  type Gender = Value
  val Male, Female = Value

  def parse(name: String): Value = values.find(_.toString.toLowerCase() == name.toLowerCase()).getOrElse(throw new RuntimeException(s"Error parsing $name to gender."))
  def parseToOption(name: String) = values.find(_.toString.toLowerCase() == name.toLowerCase())

  @transient
  implicit class StringExt_Gender(string: String) {
    def isValidGener: Boolean = Gender.parseToOption(string).isDefined;
  }
}
