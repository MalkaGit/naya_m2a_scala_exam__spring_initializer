package com.epam.services.user_providers

import com.epam.models.{Person, User}
import com.epam.models.PersonAdapter.PersonsFromJson
import com.epam.models.UserAdapter.UsersFromPersons
import com.epam.utils.TextFileReaderUtil
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import scala.collection.mutable.ListBuffer

@Component
case class PersonService(@Value("${personsFilepath}") private val personsFilepath: String, private val personValidator: PersonValidator)
  extends UserProvider {

    override def getValidUsers(): List[User] = {
      var personsJson: String = TextFileReaderUtil.readText(personsFilepath);
      val personsObjects: List[Person] = personsJson
      val validPersonsObjects: List[Person] = personsObjects.filter(personValidator.isValid);
      var validUsers: ListBuffer[User] = validPersonsObjects
      return validUsers.toList
    }
}
