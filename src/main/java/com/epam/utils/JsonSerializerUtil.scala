package com.epam.utils

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import java.io.StringWriter


object JsonSerializerUtil {

  private val mapper = JsonMapper.builder().addModule(DefaultScalaModule).build()

  def serialize(value: Any): String = {
    val writer = new StringWriter()
    mapper.writeValue(writer, value)
    val result = writer.toString
    writer.close()
    return result;
  }
}



/*
about dependencies: https://stackoverflow.com/questions/16966743/small-example-of-jackson-scala-module
code example:       https://stackoverflow.com/questions/31595362/json-serialization-of-scala-enums-using-jackson
versions:
val mapper = new ObjectMapper()
mapper.registerModule(DefaultScalaModule)

def serialize(value: Any): String = {
    import java.io.StringWriter
    val writer = new StringWriter()
    mapper.writeValue(writer, value)
    writer.toString
}
 */



