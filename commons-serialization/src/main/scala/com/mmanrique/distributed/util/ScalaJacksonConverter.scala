package com.mmanrique.distributed.util

import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class ScalaJacksonConverter {

  @Bean
  def ScalaModule: Module = {
    DefaultScalaModule
  }

}
