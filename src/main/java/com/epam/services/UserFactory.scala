package com.epam.services

import org.springframework.stereotype.Component

import scala.collection.mutable.ListBuffer
import com.epam.models.User
import com.epam.services.user_providers.interface.UserProvider

@Component
case class UserFactory(private val userProviders: java.util.List[UserProvider]) {
  def getValidUsers(): List[User] = {
    val usersLB = new ListBuffer[User]();
    userProviders.forEach(userProvider => usersLB.addAll(userProvider.getValidUsers()))
    val result = usersLB.result()
    return result
  }
}
