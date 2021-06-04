package com.epam.models.person

import com.epam.utils.JsonParserUtil

object PersonAdapter {

  implicit def PersonsFromJson(json: String): List[Person] = JsonParserUtil.parseText(json, classOf[Array[Person]]).toList
}
