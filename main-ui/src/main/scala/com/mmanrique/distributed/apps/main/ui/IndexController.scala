package com.mmanrique.distributed.apps.main.ui

import com.mmanrique.distributed.apps.flights.client.FlightsServiceClient
import com.mmanrique.distributed.apps.flights.interface.GetFlightsRequest
import com.mmanrique.distributed.apps.flights.model.Flight
import com.mmanrique.distributed.apps.main.ui.interface.{SearchRequest, SearchResults}
import com.mmanrique.distributed.experiments.client.SplitTestServiceClient
import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{GetMapping, PostMapping}

@Controller
class IndexController(@Autowired flightsServiceClient: FlightsServiceClient,
                      @Autowired splitTestClient: SplitTestServiceClient) extends LazyLogging {


  @GetMapping
  def getIndexPage(model: Model): String = {
    "index"
  }

  @PostMapping(value = Array("/search"))
  def getResults(request: SearchRequest): ResponseEntity[SearchResults] = {
    logger.info("Received request [{}]", request)
    val flightSearchResults = flightResults(request).getOrElse(List())
    val response = SearchResults(flightSearchResults, request.includeAir)
    logger.info("Returned response [{}]", response)
    ResponseEntity.ok(response)
  }

  private def flightResults(request: SearchRequest): Option[List[Flight]] = {
    if (!request.includeAir) {
      Option.empty
    } else {
      val getFlightsRequest = GetFlightsRequest(request.source, request.destination, request.departureDate)
      //TODO: This call can fail, we have to make sure that this call will not break the service
      Option(flightsServiceClient.getFlights(getFlightsRequest))
    }
  }

}
