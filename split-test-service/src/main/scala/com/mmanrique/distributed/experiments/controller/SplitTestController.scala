package com.mmanrique.distributed.experiments.controller

import com.mmanrique.distributed.experiments.dynamo.DynamoDBSplitTestRepository
import com.mmanrique.distributed.experiments.interface.{GetSplitTestRequest, GetSplitTestResponse, SplitTestInterface}
import com.mmanrique.distributed.experiments.model.SplitTestMetadata
import com.typesafe.scalalogging.LazyLogging
import io.micrometer.core.annotation.Timed
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping
class SplitTestController(@Autowired splitTestRepository: DynamoDBSplitTestRepository) extends SplitTestInterface
  with LazyLogging {

  def getSplitTest(@RequestBody getSplitTestRequest: GetSplitTestRequest): GetSplitTestResponse = {
    logger.info("Received Request [{}]", getSplitTestRequest)
    assert(Option(getSplitTestRequest).isDefined, "request can not be null")
    assert(Option(getSplitTestRequest.name).isDefined, "name can not be null")
    val result = splitTestRepository.getSplitTestValue(getSplitTestRequest.name, getSplitTestRequest.customerId)
    GetSplitTestResponse(result)
  }

  @RequestMapping(value = Array("/"), method = Array(RequestMethod.GET))
  @Timed(value = "getConnectionStatus")
  def getConnectionStatus: String = {
    logger.info("Asking for Connection Status")
    splitTestRepository.getSplitTestValue("CHEAP_FLIGHTS", None)
    "Connection is Up"
  }

  //Unfortunately, we have to add @PathVariable to the child as well
  def getSplitTestMetadata(@PathVariable name: String): SplitTestMetadata = {
    logger.info("Fetching Split Test Metadata for name {}", name)
    splitTestRepository.getSplitTestMetadata(name)
  }
}
