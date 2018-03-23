package com.mmanrique.distributed.experiments.interface

import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}

trait SplitTestInterface {

  @RequestMapping(value = Array("/"), method = Array(RequestMethod.POST))
  def getSplitTest(getSplitTestRequest: GetSplitTestRequest): GetSplitTestResponse
}
