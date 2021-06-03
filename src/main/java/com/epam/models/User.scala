package com.epam.models

import com.epam.models.enums.Gender.Gender
import com.epam.models.enums.MaritalStatus
import com.epam.models.enums.MaritalStatus.MaritalStatus
import com.sun.jdi.Value

case class User(name: String=null, phone: String=null, email: String=null, age: Int =0 , gender: Gender = null , maritalStatus: Option[MaritalStatus.Value] = null, number_of_children: Option[Int] = null)
