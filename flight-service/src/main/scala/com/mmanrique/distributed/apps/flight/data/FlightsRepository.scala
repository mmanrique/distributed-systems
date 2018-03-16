package com.mmanrique.distributed.apps.flight.data

import com.mmanrique.distributed.apps.flight.model.Flight
import org.springframework.stereotype.Component

import scala.util.Random

@Component
class FlightsRepository {

  def getFlights(source: String, destination: String): List[Flight] = {
    getRandomFlights(Random.nextInt(10))
  }

  private def getRandomFlights(count: Int): List[Flight] = {
    List.fill(count)(Flight("x", "y"))
  }

}
