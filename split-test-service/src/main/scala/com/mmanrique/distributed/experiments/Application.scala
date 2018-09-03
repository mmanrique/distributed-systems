package com.mmanrique.distributed.experiments

import com.mmanrique.distributed.experiments.dynamo.{DynamoDBBootstrapper, DynamoDBSplitTestRepository}
import com.mmanrique.distributed.util.ScalaJacksonConverter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.{CommandLineRunner, SpringApplication}
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.{Bean, Import}

@SpringBootApplication
@EnableDiscoveryClient
@Import(Array(classOf[ScalaJacksonConverter]))
class Application {

}

object Application {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[Application], args: _*)
  }

  @Bean
  def getCommandLineRunner(dynamoDBBootstrapper: DynamoDBBootstrapper, dynamoDBSplitTestRepository: DynamoDBSplitTestRepository): CommandLineRunner = {
    new CommandLineRunner {
      override def run(args: String*): Unit = {
        dynamoDBBootstrapper.bootStrap()
      }
    }
  }
}
