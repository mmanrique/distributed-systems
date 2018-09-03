package com.mmanrique.distributed.experiments.dynamo

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.{AmazonDynamoDB, AmazonDynamoDBClientBuilder}
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class DynamoDBClientFactory {

  @Bean
  def getClient: AmazonDynamoDB = {
    AmazonDynamoDBClientBuilder.standard().build()
  }

  @Bean
  def createMapper(): DynamoDBMapper ={
    new DynamoDBMapper(getClient)
  }

}
