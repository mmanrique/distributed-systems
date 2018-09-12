package com.mmanrique.distributed.experiments.interface

import com.mmanrique.distributed.experiments.model.SplitTestMetadata
import org.springframework.web.bind.annotation.{PathVariable, RequestMapping, RequestMethod}

trait SplitTestInterface {

  @RequestMapping(value = Array("/"), method = Array(RequestMethod.POST))
  def getSplitTest(getSplitTestRequest: GetSplitTestRequest): GetSplitTestResponse

  @RequestMapping(value = Array("/fetch/{name}"), method = Array(RequestMethod.GET))
  def getSplitTestMetadata(@PathVariable name: String): SplitTestMetadata
}
