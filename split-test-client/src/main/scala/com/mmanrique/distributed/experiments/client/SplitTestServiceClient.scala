package com.mmanrique.distributed.experiments.client

import com.mmanrique.distributed.experiments.interface.SplitTestInterface
import org.springframework.cloud.openfeign.FeignClient

@FeignClient("split-test-service")
trait SplitTestServiceClient extends SplitTestInterface {

}