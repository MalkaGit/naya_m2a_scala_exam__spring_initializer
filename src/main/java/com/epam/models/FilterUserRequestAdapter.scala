package com.epam.models

import com.epam.utils.JsonParserUtil
import org.springframework.beans.factory.annotation.Autowired

object FilterUserRequestAdapter {

  implicit def FromJson(json: String): List[FilterUserRequest] = JsonParserUtil.parseText(json, classOf[Array[FilterUserRequest]]).toList
}
