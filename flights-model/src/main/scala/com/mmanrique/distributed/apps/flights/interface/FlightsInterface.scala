package com.mmanrique.distributed.apps.flights.interface

import com.mmanrique.distributed.apps.flights.model.Flight
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}

trait FlightsInterface {
  @RequestMapping(value = Array("/"), method = Array(RequestMethod.POST))
  def getFlights(getFlightsRequest: GetFlightsRequest): List[Flight]
}
