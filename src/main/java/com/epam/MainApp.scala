package com.epam

import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
object MainApp {
  def main(args: Array[String]): Unit = {
    println("Hello there !")
  }
}


/*The java class
package com.epam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		System.out.println("hi !!");
	}

}
*/