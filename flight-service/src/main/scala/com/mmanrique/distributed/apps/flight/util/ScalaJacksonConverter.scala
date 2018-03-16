package com.mmanrique.distributed.apps.flight.util

import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class ScalaJacksonConverter {

  @Bean
  def ScalaModule: Module = {
    DefaultScalaModule
  }

}
