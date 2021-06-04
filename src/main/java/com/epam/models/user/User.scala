package com.epam.models.user

import com.epam.models.enums.Gender.Gender
import com.epam.models.enums.MaritalStatus

case class User(name: String = null, phone: String = null, email: String = null, age: Int = 0, gender: Gender = null, maritalStatus: Option[MaritalStatus.Value] = null, number_of_children: Option[Int] = null)
