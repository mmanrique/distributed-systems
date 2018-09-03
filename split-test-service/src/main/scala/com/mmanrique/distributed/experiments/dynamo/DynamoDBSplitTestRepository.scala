package com.mmanrique.distributed.experiments.dynamo

import com.amazonaws.services.dynamodbv2.datamodeling.{DynamoDBMapper, DynamoDBQueryExpression}
import com.amazonaws.services.dynamodbv2.model.AttributeValue
import com.mmanrique.distributed.experiments.calculation.SplitTestCalculator
import com.mmanrique.distributed.experiments.repository.SplitTestRepository
import com.typesafe.scalalogging.LazyLogging
import org.springframework.stereotype.Component

import scala.collection.JavaConverters._
import scala.collection.mutable

@Component
class DynamoDBSplitTestRepository(dynamoDBMapper: DynamoDBMapper) extends SplitTestRepository with LazyLogging {

  override def getSplitTestValue(name: String, customerId: Option[String]): String = {
    val values = Map(":val1" -> new AttributeValue().withS(name))
    val names = Map("#ts" -> "name")
    val expression = new DynamoDBQueryExpression[DynamoSplitTest]
      .withKeyConditionExpression("#ts = :val1")
      .withExpressionAttributeValues(values.asJava)
      .withExpressionAttributeNames(names.asJava)
    val scala: mutable.Buffer[DynamoSplitTest] = dynamoDBMapper.query(classOf[DynamoSplitTest], expression).asScala
    SplitTestCalculator.getSplitTestValue(scala.toList)
  }
}
