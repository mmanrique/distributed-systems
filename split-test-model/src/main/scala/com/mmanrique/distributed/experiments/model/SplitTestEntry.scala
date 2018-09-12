package com.mmanrique.distributed.experiments.model

case class SplitTestEntry(name: String,
                     value: String,
                     percentage: Int,
                     state: String = "ACTIVE") {

}
