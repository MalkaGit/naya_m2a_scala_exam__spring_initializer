package com.epam

import com.epam.context.AppDataContext
import com.epam.flow.FilterUsersFlow
import com.epam.models.enums.Gender
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.{Bean, PropertySource}
import com.google.gson.Gson
import com.sun.org.slf4j.internal.{Logger, LoggerFactory}
import lombok.extern.slf4j.Slf4j

import java.util

@SpringBootApplication
@PropertySource(Array("user_providers.properties","filter_user.properties"))
class MainApp {
}

object MainApp {

  @Bean
  def gson() : Gson =  new Gson

  def main(args: Array[String]): Unit = {
    val springContext: ConfigurableApplicationContext = SpringApplication.run(classOf[MainApp])
    val appDataContext : AppDataContext = springContext.getBean(classOf[AppDataContext]);
    val flow: FilterUsersFlow = springContext.getBean(classOf[FilterUsersFlow]);
    flow.run();
  }
}