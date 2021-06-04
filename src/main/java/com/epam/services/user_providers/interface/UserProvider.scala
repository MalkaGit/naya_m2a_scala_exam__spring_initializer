package com.epam.services.user_providers.interface

import com.epam.models.User

trait UserProvider {
  def getValidUsers(): List[User]
}
