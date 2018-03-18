package com.mmanrique.distributed.apps.flight

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.{ComponentScan, Import}
import com.mmanrique.distributed.experiments.SplitServiceClientConfiguration

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan
@Import(Array(classOf[SplitServiceClientConfiguration]))
class Application {

}

object Application {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[Application], args: _*)
  }
}
