package com.epam.services.person

import com.epam.utils.TextFileReader
import com.epam.models.person.PersonAdapter.PersonsFromJson
import com.epam.models.person.Person
import com.epam.models.user.UserAdapter.UsersFromPersons
import com.epam.models.user.User
import com.epam.services.user.UserProvider
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
