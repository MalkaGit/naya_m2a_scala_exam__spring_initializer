package com.epam.utils

import com.google.gson.{Gson, GsonBuilder, JsonElement, JsonNull, JsonSerializationContext, JsonSerializer}

import java.lang.reflect.Type

//import MyJsonProtocol._
//import spray.json._
//import DefaultJsonProtocol._ // if you don't supply your own Protocol (see below)
//import spray.json._


object JsonSerializerUtil {
  def serialize[T](obj: Object): String = {

    val builder = new GsonBuilder()
    builder.registerTypeAdapter(classOf[Option[Any]], new OptionSerializer)
    val gson = builder.create()
    return gson.toJson(obj);
  }


  class OptionSerializer extends JsonSerializer[Option[Any]] {
    def serialize(src: Option[Any], typeOfSrc: Type, context: JsonSerializationContext): JsonElement = {
      src match {
        case None => JsonNull.INSTANCE
        //case Some(b: java.sql.Blob) => context.serialize(utils.Sql.blob2String(b))
        case Some(v) => context.serialize(v)
      }
    }
  }
}






/*
case class NamedList[A](name: String, items: List[A])


 */