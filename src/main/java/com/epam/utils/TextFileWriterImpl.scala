package com.epam.utils

import org.springframework.stereotype.Component

import java.io.FileWriter

@Component
case class TextFileWriterImpl() extends TextFileWriter {

  override def writeText(text: String, filepath: String): Unit = {
    val writer = new FileWriter(filepath);
    writer.write(text);
    writer.close();
  }
}
