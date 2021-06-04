package com.epam.flow

import com.epam.models.{Client, FilterUserRequest, User}
import com.epam.models.FilterUserRequestAdapter.FromJson
import com.epam.services.FilterUserService
import com.epam.utils.ExtentionUtils.ObjectExt
import com.epam.utils.{TextFileReader, TextFileWriter}
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters.SeqHasAsJava


@Component
case class FilterUsersFlow(
  @Value("${userFilterRequestsFilepath}") private val requestsFilepath: String, @Value("${userFilterResponsesFilepath}") private val responsesFilepath: String, private val service: FilterUserService, private val  reader:TextFileReader, private val writer: TextFileWriter) {
    def run(): Unit = {
      val requestsJson: String = reader.readText(requestsFilepath);
      val requestObjects: List[FilterUserRequest]  = requestsJson;
      val resultsLB = new ListBuffer[Array[User]]()
      requestObjects.foreach(request => resultsLB += service.run(request).toArray)
      var responses = resultsLB
      writer.writeText(responses.toJson, responsesFilepath)
  }
}