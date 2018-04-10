package com.mmanrique.distributed.apps.flights.interface

import java.time.LocalDate

import com.fasterxml.jackson.annotation.JsonProperty

case class GetFlightsRequest(@JsonProperty("source") source: String,
                             @JsonProperty("destination") destination: String,
                             @JsonProperty("departureDate") departureDate: LocalDate,
                             @JsonProperty("returnDate") returnDate: Option[LocalDate]) {
}
