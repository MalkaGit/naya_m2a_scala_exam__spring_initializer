package com.epam.utils

import org.springframework.stereotype.Component

trait TextFileWriter {
  def writeText(text: String, filepath: String): Unit
}
