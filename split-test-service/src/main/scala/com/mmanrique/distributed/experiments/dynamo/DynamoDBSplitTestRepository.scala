package com.mmanrique.distributed.experiments.dynamo

import com.amazonaws.services.dynamodbv2.datamodeling.{DynamoDBMapper, DynamoDBQueryExpression}
import com.amazonaws.services.dynamodbv2.model.AttributeValue
import com.mmanrique.distributed.experiments.calculation.SplitTestCalculator
import com.mmanrique.distributed.experiments.converter.SplitTestConverter
import com.mmanrique.distributed.experiments.model.SplitTestMetadata
import com.mmanrique.distributed.experiments.repository.SplitTestRepository
import com.typesafe.scalalogging.LazyLogging
import org.springframework.stereotype.Component

import scala.collection.JavaConverters._
import scala.collection.mutable

@Component
class DynamoDBSplitTestRepository(dynamoDBMapper: DynamoDBMapper) extends SplitTestRepository with LazyLogging {
  def getSplitTestMetadata(name: String): SplitTestMetadata = {
    val converter = new SplitTestConverter
    val values = getSplitTestsByName(name).map(dynamo => converter.fromDynamo(dynamo))
    SplitTestMetadata(values)
  }


  override def getSplitTestValue(name: String, customerId: Option[String]): String = {
    val splitTestValue = getSplitTestsByName(name)
    SplitTestCalculator.getSplitTestValue(splitTestValue)
  }

  private def getSplitTestsByName(name: String): List[DynamoSplitTest] = {
    val values = Map(":val1" -> new AttributeValue().withS(name))
    val names = Map("#ts" -> "name")
    val expression = new DynamoDBQueryExpression[DynamoSplitTest]
      .withKeyConditionExpression("#ts = :val1")
      .withExpressionAttributeValues(values.asJava)
      .withExpressionAttributeNames(names.asJava)
    val scala: mutable.Buffer[DynamoSplitTest] = dynamoDBMapper.query(classOf[DynamoSplitTest], expression).asScala
    logger.info("Got {} elements for {}", scala.size, name)
    scala.toList
  }
}
