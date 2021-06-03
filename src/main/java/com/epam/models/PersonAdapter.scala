package com.epam.models

import com.epam.utils.JsonParserUtil

object PersonAdapter {
  implicit def PersonsFromJson(json: String): List[Person] = JsonParserUtil.parseText(json, classOf[Array[Person]]).toList
}
