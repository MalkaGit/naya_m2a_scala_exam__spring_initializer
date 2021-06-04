package com.epam.services

import com.epam.models.Person
import com.epam.utils.ExtentionUtils.StringExt
import org.springframework.stereotype.Component

@Component
case class PersonValidator() {
  def isValid(person: Person): Boolean =
    person.age.isValidAge &&
      person.email.isValidEmail &&
      person.phone.isValidPhone
}
