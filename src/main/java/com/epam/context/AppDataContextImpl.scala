package com.epam.context

import com.epam.models.user.User
import com.epam.services.user.UserFactory
import org.springframework.stereotype.Component

@Component
case class AppDataContextImpl(private val userFactory: UserFactory) extends AppDataContext {

  override var cachedUsers: List[User] = Nil

   loadValidData();

  private def loadValidData(): Unit = {
    this.cachedUsers  = userFactory.getValidUsers();
  };
}
