package com.epam.repositories

import com.epam.models.user.{FilterUserRequest, User}

trait UserRepository {
  def filter(request: FilterUserRequest): List[User]
}
