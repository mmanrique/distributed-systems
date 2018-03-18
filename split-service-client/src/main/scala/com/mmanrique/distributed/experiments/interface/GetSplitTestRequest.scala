package com.mmanrique.distributed.experiments.interface

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}

@JsonCreator
case class GetSplitTestRequest(@JsonProperty("name") name: String,
                               @JsonProperty(value = "customerId", required = false) customerId: Option[String] = None) {

}
