package com.mmanrique.distributed.experiments.controller

import com.mmanrique.distributed.experiments.interface.{GetSplitTestRequest, GetSplitTestResponse}
import com.mmanrique.distributed.experiments.repository.SplitTestRepository
import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{RequestBody, RequestMapping, RequestMethod, RestController}

@RestController
@RequestMapping
class SplitTestController(@Autowired splitTestRepository: SplitTestRepository) extends LazyLogging {

  @RequestMapping(method = Array(RequestMethod.POST))
  def getSplitTest(@RequestBody getSplitTestRequest: GetSplitTestRequest): GetSplitTestResponse = {
    logger.info("Received Request [{}]", getSplitTestRequest)
    assert(Option(getSplitTestRequest).isDefined, "request can not be null")
    assert(Option(getSplitTestRequest.name).isDefined, "name can not be null")
    val result = splitTestRepository.getSplitTestValue(getSplitTestRequest.name, Option(getSplitTestRequest.customerId))
    GetSplitTestResponse(result)
  }

}
