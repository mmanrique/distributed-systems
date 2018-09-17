package com.mmanrique.distributed.experiments.converter

import com.mmanrique.distributed.experiments.dynamo.DynamoSplitTest
import com.mmanrique.distributed.experiments.model.SplitTestEntry

class SplitTestConverter {

  def fromDynamo(dynamo:DynamoSplitTest): SplitTestEntry = {
    SplitTestEntry(dynamo.name, dynamo.value, dynamo.percentage, dynamo.state)
  }
}

