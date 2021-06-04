package com.epam.context

import com.epam.models.User
import com.epam.services.UserFactory
import org.springframework.stereotype.Component

@Component
case class AppDataContextImpl(private val userFactory: UserFactory) extends AppDataContext {

  override var cachedUsers: List[User] = Nil

   loadValidData();

  private def loadValidData(): Unit = {
    this.cachedUsers  = userFactory.getValidUsers();
  };
}
