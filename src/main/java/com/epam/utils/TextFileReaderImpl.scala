package com.epam.utils

import org.springframework.stereotype.Component

@Component
case class TextFileReaderImpl() extends TextFileReader() {

  override def readText(filepath: String): String = {
    val bufferedSource = scala.io.Source.fromFile(filepath)
    val text: String = bufferedSource.getLines.mkString
    bufferedSource.close()
    return text;
  }

  override def readLines(filepath: String): List[String] = {
    val bufferedSource = scala.io.Source.fromFile(filepath)
    val lines: List[String] = bufferedSource.getLines().toList
    bufferedSource.close()
    return lines;
  }
}