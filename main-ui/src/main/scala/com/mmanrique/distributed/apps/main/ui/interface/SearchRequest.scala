package com.mmanrique.distributed.apps.main.ui.interface

import java.util.Date

case class SearchRequest(source: String,
                         destination: String,
                         departureDate: Date = new Date(),
                         returnDate: Date = new Date(),
                         isRoundTrip: Boolean = true,
                         includeAir: Boolean = true,
                         includeCar: Boolean = false,
                         includeActivity: Boolean = false) {

}
