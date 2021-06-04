package com.epam.services

import com.epam.models.{Person, User}
import com.epam.models.PersonAdapter.PersonsFromJson
import com.epam.models.UserAdapter.UsersFromPersons
import com.epam.services.interface.UserProvider
import com.epam.utils.TextFileReader
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import scala.collection.mutable.ListBuffer

@Component
case class PersonUserProvider(@Value("${personsFilepath}") private val personsFilepath: String, private val personValidator: PersonValidator, private val reader: TextFileReader)
  extends UserProvider {

  override def getValidUsers(): List[User] = {
    var personsJson: String = reader.readText(personsFilepath);
    val personsObjects: List[Person] = personsJson
    val validPersonsObjects: List[Person] = personsObjects.filter(personValidator.isValid);
    var validUsers: ListBuffer[User] = validPersonsObjects
    return validUsers.toList
  }
}
