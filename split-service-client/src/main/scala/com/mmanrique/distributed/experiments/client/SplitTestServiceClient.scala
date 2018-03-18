package com.mmanrique.distributed.experiments.client

import com.mmanrique.distributed.experiments.interface.GetSplitTestResponse

trait SplitTestServiceClient {

  def Path: String = "http://split-test-service/"

  def getSplitTest(name: String, customerId: Option[String] = None): GetSplitTestResponse
}