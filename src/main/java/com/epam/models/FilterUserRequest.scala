package com.epam.models

case class FilterUserRequest(prefix_name: String="", min_age: String="", max_age: String="", gender: String="", marital_status: String="", number_of_children: String="")