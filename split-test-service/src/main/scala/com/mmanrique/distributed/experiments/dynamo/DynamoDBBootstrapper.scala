package com.mmanrique.distributed.experiments.dynamo

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.model.{CreateTableRequest, ProvisionedThroughput}
import org.springframework.stereotype.Component

@Component
class DynamoDBBootstrapper(mapper: DynamoDBMapper, dynamoClient: AmazonDynamoDB) {


  def bootStrap(): Unit = {
    if (!tableExists(DynamoSplitTest.TABLE_NAME)) {
      val request: CreateTableRequest = mapper.generateCreateTableRequest(classOf[DynamoSplitTest])
        .withProvisionedThroughput(new ProvisionedThroughput()
          .withReadCapacityUnits(1L)
          .withWriteCapacityUnits(1L))
      dynamoClient.createTable(request)
    }
  }

  def tableExists(name: String): Boolean = {
    try {
      val result = dynamoClient.describeTable(DynamoSplitTest.TABLE_NAME)
    } catch {
      case _: Exception => return false
    }
    true
  }
}
