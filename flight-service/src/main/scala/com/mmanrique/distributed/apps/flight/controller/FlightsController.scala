package com.mmanrique.distributed.apps.flight.controller

import com.mmanrique.distributed.apps.flight.data.FlightsRepository
import com.mmanrique.distributed.apps.flight.interface.GetFlightsRequest
import com.mmanrique.distributed.apps.flight.model.Flight
import com.mmanrique.distributed.experiments.client.SplitTestServiceClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{RequestBody, RequestMapping, RequestMethod, RestController}

@RestController
@RequestMapping
class FlightsController(@Autowired repository: FlightsRepository,
                        @Autowired splitTestServiceClient: SplitTestServiceClient) {

  @RequestMapping(method = Array(RequestMethod.POST))
  def getFlights(@RequestBody getFlightsRequest: GetFlightsRequest): List[Flight] = {
    assert(getFlightsRequest != null, "request can not be null")
    assert(getFlightsRequest.source != null, "source location can not be null")
    assert(getFlightsRequest.destination != null, "destination can not be null")
    repository.getFlights(getFlightsRequest.source, getFlightsRequest.destination)
  }

  @RequestMapping(method = Array(RequestMethod.GET))
  def getFlightsPage: String = {
    if (splitTestServiceClient.getSplitTest("CHEAP_FLIGHTS").value == "EXPERIMENT_1")
      "You're in the CHEAP flights page"
    else
      "You're in the flights page"

  }

}
