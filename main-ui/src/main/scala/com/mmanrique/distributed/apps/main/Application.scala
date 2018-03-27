package com.mmanrique.distributed.apps.main

import com.mmanrique.distributed.apps.flights.client.FlightsServiceClient
import com.mmanrique.distributed.experiments.client.SplitTestServiceClient
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(basePackageClasses = Array(classOf[FlightsServiceClient], classOf[SplitTestServiceClient]))
class Application {

}


object Application {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[Application], args: _*)
  }
}