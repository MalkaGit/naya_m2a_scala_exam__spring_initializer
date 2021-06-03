package com.epam.services.user_providers

import com.epam.models.User

trait UserProvider {
  def getValidUsers(): List[User]
}
