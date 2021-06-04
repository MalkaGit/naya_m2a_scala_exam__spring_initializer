package com.epam.context

import com.epam.models.User

trait AppDataContext {
  var cachedUsers: List[User]
}
