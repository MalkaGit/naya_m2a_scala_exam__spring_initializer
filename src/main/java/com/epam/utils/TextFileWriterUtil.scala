package com.epam.utils

import java.io.FileWriter

object TextFileWriterUtil {
    def writeText(text: String, filepath: String): Unit = {
      val writer = new FileWriter(filepath);
      writer.write(text);
      writer.close();
    }
}
