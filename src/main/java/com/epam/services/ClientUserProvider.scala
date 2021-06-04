package com.epam.services

import com.epam.models.{Client, User}
import com.epam.services.interface.UserProvider
import com.epam.utils.TextFileReader
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import scala.collection.mutable.ListBuffer
import com.epam.models.ClientAdapter.clientsFromLines
import com.epam.models.UserAdapter.UsersFromClients

@Component
case class ClientUserProvider(@Value("${clientsFilepath}") private val clientsFilepath: String, private val clientValidator: ClientValidator, private val reader: TextFileReader)
  extends UserProvider {

  override def getValidUsers(): List[User] = {
    var clientLines: List[String] = reader.readLines(clientsFilepath);
    val clientObjects: List[Client] = clientLines;
    var validClientObjects: List[Client] = clientObjects.filter(clientValidator.isValid);
    var validUsers: ListBuffer[User] = validClientObjects;
    return validUsers.toList
  }
}
