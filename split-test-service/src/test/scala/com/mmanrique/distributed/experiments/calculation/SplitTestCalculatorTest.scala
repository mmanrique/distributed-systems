package com.mmanrique.distributed.experiments.calculation

import com.mmanrique.distributed.experiments.dynamo.DynamoSplitTest
import org.scalatest.FunSuite

class SplitTestCalculatorTest extends FunSuite {
  test("Generate obvious response out of a single state") {
    val str = SplitTestCalculator.getSplitTestValue(List(DynamoSplitTest("Name", "C1", 20)))
    assert(str === "C1")
  }

  test("Generate obvious response out of a two states with one being zero") {
    val tests = List(DynamoSplitTest("Name", "C1", 0), DynamoSplitTest("Name", "C2", 100))
    val str = SplitTestCalculator.getSplitTestValue(tests)
    assert(str === "C2")
  }

  test("Generate obvious response out of a two states with one being zero unordered") {
    val tests = List(DynamoSplitTest("Name", "C1", 100), DynamoSplitTest("Name", "C2", 0))
    val str = SplitTestCalculator.getSplitTestValue(tests)
    assert(str === "C1")
  }
}