package com.epam.app.context

import com.epam.models.User
import com.epam.services.UserFactory
import org.springframework.stereotype.Component

@Component
case class AppContextImpl(private val userFactory: UserFactory) extends AppContext {

  override var cachedUsers: List[User] = Nil

   loadValidData();

  private def loadValidData(): Unit = {
    this.cachedUsers  = userFactory.getValidUsers();
  };
}
