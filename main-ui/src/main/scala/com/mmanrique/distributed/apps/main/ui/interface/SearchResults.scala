package com.mmanrique.distributed.apps.main.ui.interface

import com.mmanrique.distributed.apps.flights.model.Flight

case class SearchResults(flights: List[Flight],
                         searchedForFlights: Boolean) {

}
