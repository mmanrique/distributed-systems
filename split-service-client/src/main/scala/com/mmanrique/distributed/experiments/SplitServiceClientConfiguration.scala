package com.mmanrique.distributed.experiments

import org.springframework.context.annotation.{ComponentScan, Configuration}

@Configuration
@ComponentScan(Array("com.mmanrique.distributed.experiments.client"))
class SplitServiceClientConfiguration {

}
