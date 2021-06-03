package com.epam.models

import com.epam.models.enums.{Gender, MaritalStatus}

import scala.collection.mutable.ListBuffer


object UserAdapter {
  implicit class UsersFromClients(clients: List[Client]) extends ListBuffer[User]() {
    clients.foreach(client => this += client)
  }

  implicit class UserFromClient(client: Client) extends User(
    client.firstName + " " + client.lastName, client.phone, client.email,
    client.age.toIntOption.getOrElse(throw new RuntimeException(s"Error parsing ${client.age} to age.")),
    Gender.parse(client.gender), MaritalStatus.parseToOption(client.marital_status),
    client.number_of_children.toIntOption) {}

  implicit class UsersFromPersons(persons: List[Person]) extends ListBuffer[User] {
    persons.foreach(person => this += person)
  }

  implicit class UserFromPerson(person: Person) extends User(
    person.name, person.phone, person.email,
    person.age.toIntOption.getOrElse(throw new RuntimeException(s"Error parsing ${person.age} to age.")),
    Gender.parse(person.gender), None, None) {}
}
