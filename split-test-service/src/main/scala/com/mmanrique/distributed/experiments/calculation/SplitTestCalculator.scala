package com.mmanrique.distributed.experiments.calculation

import com.mmanrique.distributed.experiments.dynamo.DynamoSplitTest

import scala.util.Random


object SplitTestCalculator {

  //This might be changed to use Tail recursive optimization
  //I don't know if this has good performance, but that's what we're trying to learn in the next couple of months
  /**
    * Given a list of split tests, we calculate a random value based on the distribution
    *
    * @param splitTestList a list of DynamoSplitTest
    * @return a string being a random pick from the distribution provided.
    */
  def getSplitTestValue(splitTestList: List[DynamoSplitTest]): String = {
    val percentangeOffsets = splitTestList.foldLeft(Array[(Int, DynamoSplitTest)]()) { (acumulator, dynamoSplitTest) =>
      acumulator match {
        case Array() => acumulator :+ (dynamoSplitTest.percentage, dynamoSplitTest)
        case list => acumulator :+ (list.last._1 + dynamoSplitTest.percentage, dynamoSplitTest)
      }
    }
    //Considering that the amount of states that one Split Test can have, we can use a linear search.
    val randomInt = Random.nextInt(100)
    if (percentangeOffsets.length == 1) {
      percentangeOffsets(0)._2.value
    } else {
      percentangeOffsets.dropWhile(_._1 < randomInt).head._2.value
    }
  }

}