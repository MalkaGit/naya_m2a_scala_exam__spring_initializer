package com.epam.repositories

import com.epam.models.{User, FilterUserRequest}

trait UserRepository {
  def filter(request: FilterUserRequest): List[User]
}
