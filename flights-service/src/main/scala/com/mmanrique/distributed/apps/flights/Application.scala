package com.mmanrique.distributed.apps.flights

import com.mmanrique.distributed.experiments.client.SplitTestServiceClient
import com.mmanrique.distributed.util.ScalaJacksonConverter
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Import

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = Array(classOf[SplitTestServiceClient]))
@Import(Array(classOf[ScalaJacksonConverter]))
class Application {

}

object Application {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[Application], args: _*)
  }
}
