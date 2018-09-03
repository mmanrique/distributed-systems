package com.mmanrique.distributed.experiments.dynamo

import com.amazonaws.services.dynamodbv2.datamodeling.{DynamoDBHashKey, DynamoDBRangeKey, DynamoDBTable}

import scala.annotation.meta.beanGetter
import scala.beans.BeanProperty

@DynamoDBTable(tableName = DynamoSplitTest.TABLE_NAME)
case class DynamoSplitTest(
                       @(DynamoDBHashKey@beanGetter)
                       @BeanProperty var name: String,
                       @(DynamoDBRangeKey@beanGetter)
                       @BeanProperty var value: String,
                       @BeanProperty var percentage: Int,
                       @BeanProperty var state: String = "ACTIVE") {

  def this() = this(null, null, 0, null)
}

object DynamoSplitTest {
   final val TABLE_NAME = "SPLIT_TEST"
}
