package com.mmanrique.distributed.experiments.ui.controller

import com.mmanrique.distributed.experiments.client.SplitTestServiceClient
import com.mmanrique.distributed.experiments.model.SplitTestMetadata
import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController(@Autowired splitTestClient: SplitTestServiceClient) extends LazyLogging {

  @GetMapping(value = Array("/fetch"))
  def fetchResults(name: String): ResponseEntity[SplitTestMetadata] = {
    logger.info("Getting Metadata for name [{}]", name)
    val value = splitTestClient.getSplitTestMetadata(name)
    logger.info("Returning Metadata")
    ResponseEntity.ok(value)

  }

}
