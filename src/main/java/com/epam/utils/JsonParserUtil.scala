package com.epam.utils

import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import java.io.FileReader

object JsonParserUtil {
  def parseText[T](text: String, t: Class[T]): T = {
    val gson = new Gson;
    val data: T = gson.fromJson(text, t) // contains the whole t list
    return data
  }
}
