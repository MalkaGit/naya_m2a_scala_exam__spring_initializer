package com.epam.utils

import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import org.springframework.stereotype.Component
import java.io.FileReader

object JsonParserUtil {

  private val gson = new Gson()

  def parseText[T](text: String, t: Class[T]): T = {
    val data: T = gson.fromJson(text, t)
    return data
  }
}