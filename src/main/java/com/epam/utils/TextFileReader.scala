package com.epam.utils

trait TextFileReader {
  def readText(filepath: String): String
  def readLines(filepath: String): List[String]
}