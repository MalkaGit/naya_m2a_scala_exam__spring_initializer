package com.epam.services.user

import com.epam.models.user.User

trait UserProvider {
  def getValidUsers(): List[User]
}
