package com.epam.models

import scala.collection.mutable.ListBuffer

object ClientAdapter {
  implicit def clientsFromLines(lines: List[String]): List[Client] = {
    var clientsLB = new ListBuffer[Client]()
    lines.foreach(line => clientsLB += line)
    return clientsLB.toList
  }

  implicit class clientFromLine(line: String) extends Client() {
    val values = line.split(",")
    firstName = values(0)
    lastName = values(1)
    gender = values(2)
    age = values(3)
    email = values(4)
    phone = values(5)
    education = values(6)
    occupation = values(7)
    salary = values(8)
    marital_status = values(9)
    number_of_children = values(10)
  }
}
