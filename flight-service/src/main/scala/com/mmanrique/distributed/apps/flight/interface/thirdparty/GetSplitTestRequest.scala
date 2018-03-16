package com.mmanrique.distributed.apps.flight.interface.thirdparty

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}

@JsonCreator
case class GetSplitTestRequest(@JsonProperty("name") name: String,
                               @JsonProperty("customerId") customerId: Option[String] = None) {



}
