package com.epam.services.user_providers

import com.epam.models.{Client, User}
import com.epam.models.ClientAdapter.clientsFromLines
import com.epam.models.UserAdapter.UsersFromClients
import com.epam.utils.TextFileReaderUtil
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import scala.collection.mutable.ListBuffer

@Component
case class ClientService(@Value("${clientsFilepath}") private val clientsFilepath: String, private val clientValidator: ClientValidator)
    extends UserProvider {

  override def getValidUsers(): List[User] = {
    var clientLines: List[String] = TextFileReaderUtil.readLines(clientsFilepath);
    val clientObjects: List[Client] = clientLines;
    var validClientObjects: List[Client] = clientObjects.filter(clientValidator.isValid);
    var validUsers: ListBuffer[User] = validClientObjects;
    return validUsers.toList
  }
}

































//var c = clientObjects.last;
//var x = clientValidator.isValid(c);