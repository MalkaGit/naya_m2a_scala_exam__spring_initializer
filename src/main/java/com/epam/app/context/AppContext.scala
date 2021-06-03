package com.epam.app.context

import com.epam.models.User

trait AppContext {
  var cachedUsers: List[User]
}
