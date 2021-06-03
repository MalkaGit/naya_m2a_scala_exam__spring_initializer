package com.epam.utils

import com.google.gson.Gson
import com.google.gson.stream.JsonReader

import java.io.FileReader

object JsonFileReader {
   def read[T](filepath: String, t: Class[T]): T = {
      val gson = new Gson;
      val reader = new JsonReader(new FileReader(filepath))
      val data: T = gson.fromJson(reader, t) // contains the whole t list
      reader.close();
      return data
  }
}
