package com.mmanrique.distributed.apps.flights.controller

import com.mmanrique.distributed.apps.flights.data.FlightsRepository
import com.mmanrique.distributed.apps.flights.interface.{FlightsInterface, GetFlightsRequest}
import com.mmanrique.distributed.apps.flights.model.Flight
import com.mmanrique.distributed.experiments.client.SplitTestServiceClient
import com.mmanrique.distributed.experiments.interface.GetSplitTestRequest
import com.typesafe.scalalogging.LazyLogging
import org.apache.commons.lang.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{RequestBody, RequestMapping, RequestMethod, RestController}

@RestController
@RequestMapping
class FlightsController(@Autowired repository: FlightsRepository,
                        @Autowired splitTestServiceClient: SplitTestServiceClient)
  extends FlightsInterface with LazyLogging {

  def getFlights(@RequestBody request: GetFlightsRequest): List[Flight] = {
    assert(request != null, "request can not be null")
    assert(StringUtils.isNotBlank(request.source), "source location can not be null")
    assert(StringUtils.isNotBlank(request.destination), "destination can not be null")
    logger.info("Received request [{}]", request)
    repository.getFlights(request.source, request.destination)
  }

  @RequestMapping(method = Array(RequestMethod.GET))
  def getFlightsPage: String = {
    if (splitTestServiceClient.getSplitTest(GetSplitTestRequest("CHEAP_FLIGHTS")).value == "EXPERIMENT_1")
      "You're in the CHEAP flights page"
    else
      "You're in the flights page"

  }

}
