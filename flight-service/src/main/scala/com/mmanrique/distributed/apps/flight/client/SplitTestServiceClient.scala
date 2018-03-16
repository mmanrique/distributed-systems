package com.mmanrique.distributed.apps.flight.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.mmanrique.distributed.apps.flight.interface.thirdparty.{GetSplitTestRequest, GetSplitTestResponse}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.ParameterizedTypeReference
import org.springframework.hateoas.Resources
import org.springframework.http.{HttpEntity, HttpHeaders, HttpMethod, MediaType}
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class SplitTestServiceClient(@Autowired restTemplate: RestTemplate,
                             @Autowired mapper: ObjectMapper) {


  def getSplitTest(name: String, customerId: Option[String] = None): GetSplitTestResponse = {
    val payload = GetSplitTestRequest(name, customerId)
    val headers: HttpHeaders = new HttpHeaders()
    headers.setContentType(MediaType.APPLICATION_JSON)
    val entity = new HttpEntity[String](mapper.writeValueAsString(payload), headers)
    val parameterizedTypeReference = new ParameterizedTypeReference[Resources[GetSplitTestResponse]]() {}
    val response = restTemplate.exchange(SplitTestServiceClient.Path, HttpMethod.POST, entity, classOf[GetSplitTestResponse])
    response.getBody
  }
}

object SplitTestServiceClient {
  def Path: String = "http://split-test-service/"
}