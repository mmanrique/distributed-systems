package com.mmanrique.distributed.apps.flights.interface

import java.util.Date

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}

@JsonCreator
case class GetFlightsRequest(@JsonProperty("source") source: String,
                             @JsonProperty("destination") destination: String,
                             @JsonProperty("date") date: Date = new Date()) {

}
