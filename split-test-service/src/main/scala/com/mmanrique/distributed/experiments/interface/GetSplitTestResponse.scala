package com.mmanrique.distributed.experiments.interface

import com.fasterxml.jackson.annotation.JsonProperty

case class GetSplitTestResponse(@JsonProperty("value") value: String) {

}
