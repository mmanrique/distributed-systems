package com.mmanrique.distributed.apps.flights.interface

import java.time.LocalDate

case class GetFlightsRequest(source: String,
                             destination: String,
                             departureDate: LocalDate,
                             returnDate: Option[LocalDate]) {
}
