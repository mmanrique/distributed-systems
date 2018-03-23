package com.mmanrique.distributed.experiments

import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration}
import org.springframework.web.client.RestTemplate

@Configuration
@ComponentScan(Array("com.mmanrique.distributed.experiments.client"))
class SplitServiceClientConfiguration {

  @Bean
  @LoadBalanced
  def restTemplate:RestTemplate = new RestTemplate()

}
