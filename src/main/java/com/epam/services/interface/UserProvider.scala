package com.epam.services.interface

import com.epam.models.User

trait UserProvider {
  def getValidUsers(): List[User]
}
