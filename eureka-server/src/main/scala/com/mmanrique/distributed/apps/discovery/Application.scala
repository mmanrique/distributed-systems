package com.mmanrique.distributed.apps.discovery

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer
import org.springframework.context.annotation.ComponentScan


@EnableAutoConfiguration
@ComponentScan
@EnableEurekaServer
class Application {

}

object Application {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[Application], args: _*)
  }
}
