package com.epam.services.client

import com.epam.models.client.Client
import com.epam.models.enums.Gender.StringExt_Gender
import com.epam.models.enums.MaritalStatus.StringExt_MaritalStatus
import com.epam.utils.ExtentionUtils.StringExt
import org.springframework.stereotype.Component

@Component
case class ClientValidator() {
  def isValid(client: Client): Boolean =
    client.gender.isValidGener &&
      client.marital_status.isValidMaritalStatus &&
      client.age.isValidAge &&
      client.number_of_children.isValidNumberOfChildren &&
      client.email.isValidEmail &&
      client.phone.isValidPhone &&
      !client.firstName.isEmpty &&
      !client.lastName.isEmpty;
}
