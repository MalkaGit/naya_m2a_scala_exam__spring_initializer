package com.epam.repositories

import com.epam.models.FilterUserRequest
import com.epam.models.{FilterUserRequest, User}

trait UserRepository {
  def filter(request: FilterUserRequest): List[User]
}
