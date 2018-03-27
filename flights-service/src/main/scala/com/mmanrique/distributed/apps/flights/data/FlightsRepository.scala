package com.mmanrique.distributed.apps.flights.data

import com.mmanrique.distributed.apps.flights.model.Flight
import org.springframework.stereotype.Component

import scala.util.Random

@Component
class FlightsRepository {

  def getFlights(source: String, destination: String): List[Flight] = {
    getRandomFlights(source, destination, Random.nextInt(10))
  }

  private def getRandomFlights(source: String, destination: String, count: Int): List[Flight] = {
    List.fill(count)(Flight(source, destination, Random.nextInt(200)))
  }

}
