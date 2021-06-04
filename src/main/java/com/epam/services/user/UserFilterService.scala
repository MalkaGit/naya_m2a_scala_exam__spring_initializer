package com.epam.services.user

import com.epam.models.user.{FilterUserRequest, User}
import com.epam.repositories.UserRepository
import org.springframework.stereotype.Component

@Component
case class UserFilterService(private val repository: UserRepository) {

  def run(request: FilterUserRequest): List[User] = {
    return repository.filter(request)
  }
}
