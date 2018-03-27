package com.mmanrique.distributed.apps.flights.client

import com.mmanrique.distributed.apps.flights.interface.FlightsInterface
import org.springframework.cloud.openfeign.FeignClient

@FeignClient("flight-search-service")
trait FlightsServiceClient extends FlightsInterface {

}
