
package com.epam

import com.epam.app.context.AppContext
import com.epam.flow.FilterUsersFlow
import com.epam.models.enums.Gender
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.{Bean, PropertySource}
import com.google.gson.Gson

import java.util

@SpringBootApplication
@PropertySource(Array("user_providers.properties"))
class MainApp {
}

object MainApp {

  def main(args: Array[String]): Unit = {
    val springContext: ConfigurableApplicationContext = SpringApplication.run(classOf[MainApp])
    val appDataContext : AppContext = springContext.getBean(classOf[AppContext]);
    println(appDataContext.cachedUsers)

    val flow: FilterUsersFlow = springContext.getBean(classOf[FilterUsersFlow]);
    flow.run();
  }

  @Bean
  def gson() : Gson =  new Gson
}