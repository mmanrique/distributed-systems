package com.mmanrique.distributed.experiments.client.impl

import com.fasterxml.jackson.databind.ObjectMapper
import com.mmanrique.distributed.experiments.client.SplitTestServiceClient
import com.mmanrique.distributed.experiments.interface.{GetSplitTestRequest, GetSplitTestResponse}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{HttpEntity, HttpHeaders, HttpMethod, MediaType}
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class SplitTestServiceClientImpl(@Autowired restTemplate: RestTemplate,
                                 @Autowired mapper: ObjectMapper) extends SplitTestServiceClient {


  def getSplitTest(name: String, customerId: Option[String] = None): GetSplitTestResponse = {
    val payload = GetSplitTestRequest(name, customerId)
    val headers: HttpHeaders = new HttpHeaders()
    headers.setContentType(MediaType.APPLICATION_JSON)
    val entity = new HttpEntity[String](mapper.writeValueAsString(payload), headers)
    val response = restTemplate.exchange(this.Path, HttpMethod.POST, entity, classOf[GetSplitTestResponse])
    response.getBody
  }
}