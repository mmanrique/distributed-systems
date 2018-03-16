package com.mmanrique.distributed.apps.flight.util

import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class RestTemplateBean {

  @Bean
  @LoadBalanced
  def getRestTemplate = new RestTemplate()

}
