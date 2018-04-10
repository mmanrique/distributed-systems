package com.mmanrique.distributed.apps.main.ui.interface


import java.time.LocalDate

import com.fasterxml.jackson.annotation.{JsonFormat, JsonProperty}

case class SearchRequest(@JsonProperty(value = "source", required = true) source: String,
                         @JsonProperty(value = "destination", required = true) destination: String,
                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") @JsonProperty(value = "departure-date", required = true) departureDate: LocalDate,
                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") @JsonProperty("return-date") returnDate: Option[LocalDate],
                         @JsonProperty("air") excludeAir: Boolean,
                         @JsonProperty("car") includeCar: Boolean,
                         @JsonProperty("activity") includeActivity: Boolean) {

  def includeAir: Boolean = !excludeAir
}
