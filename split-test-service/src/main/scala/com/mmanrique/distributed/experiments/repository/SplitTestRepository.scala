package com.mmanrique.distributed.experiments.repository


import com.datastax.driver.core.Row
import com.datastax.driver.core.querybuilder.QueryBuilder
import com.mmanrique.distributed.experiments.cassandra.CassandraGateway
import com.mmanrique.distributed.experiments.model.{SplitTest, SplitTestState}
import org.springframework.stereotype.Component

import scala.collection.JavaConverters._
import scala.util.Random

@Component
class SplitTestRepository(cassandraGateway: CassandraGateway) {


  def getSplitTestValue(name: String, customerId: Option[String]): String = {
    val session = cassandraGateway.getSession()
    val clause = QueryBuilder.select().all().from("split_test").where(QueryBuilder.eq("name", name))
    val resultSet = session.execute(clause)
    val splitTestStates = for (row <- resultSet.asScala.toList) yield parseDatabaseRow(row)
    SplitTestRepository.getSplitTestValue(SplitTest(name, splitTestStates))
  }

  private def parseDatabaseRow(row: Row): SplitTestState = {
    SplitTestState(row.getString("type"), row.getDouble("percentage"))
  }

}

object SplitTestRepository {
  //This might be changed to use Tail recursive optimization
  //I don't know if this has good performance, but that's what we're trying to learn in the next couple of months
  def getSplitTestValue(splitTest: SplitTest): String = {
    val percentangeOffsets = splitTest.states.foldLeft(Array[(Double, SplitTestState)]()) { (acumulator, value) =>
      acumulator match {
        case Array() => acumulator :+ (value.percentage, value)
        case list => acumulator :+ (list.last._1 + value.percentage, value)
      }
    }
    //Considering that the amount of states that one Split Test can have, we can use a linear search.
    val randomInt = Random.nextInt(100)
    if (percentangeOffsets.length == 1) {
      percentangeOffsets(0)._2.testType
    } else {
      percentangeOffsets.dropWhile(_._1 < randomInt).head._2.testType

    }
  }


}
