package com.epam.context

import com.epam.models.user.User

trait AppDataContext {
  var cachedUsers: List[User]
}
