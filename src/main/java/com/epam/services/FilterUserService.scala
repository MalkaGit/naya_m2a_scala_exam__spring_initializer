package com.epam.services

import com.epam.models.{FilterUserRequest, User}
import com.epam.repositories.UserRepository
import com.epam.utils.TextFileReader
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
case class FilterUserService(private val repository: UserRepository) {

  def run(request: FilterUserRequest): List[User] = {
    return repository.filter(request)
  }
}
