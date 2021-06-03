package com.epam.models

import com.epam.utils.JsonParserUtil

object FilterUserRequestAdapter {
  implicit def FromJson(json: String): List[FilterUserRequest] = JsonParserUtil.parseText(json, classOf[Array[FilterUserRequest]]).toList
}
