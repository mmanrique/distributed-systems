package com.mmanrique.distributed.experiments.client

import com.mmanrique.distributed.experiments.interface.{GetSplitTestRequest, GetSplitTestResponse}
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}

@FeignClient("split-test-service")
trait SplitTestServiceClient {

  @RequestMapping(value = Array("/"), method = Array(RequestMethod.POST))
  def getSplitTest(getSplitTestRequest: GetSplitTestRequest): GetSplitTestResponse
}