package com.mmanrique.distributed.experiments.repository

import com.mmanrique.distributed.experiments.model.{SplitTest, SplitTestState}
import org.scalatest.FunSuite

class SplitTestRepositoryTest extends FunSuite {

  test("Generate obvious response out of a single state") {
    val list: List[SplitTestState] = List(SplitTestState("C1", 20))
    val splitTest = SplitTest("Name", list)
    val str = SplitTestRepository.getSplitTestValue(splitTest)
    assert(str === "C1")
  }

  test("Generate obvious response out of a two states with one being zero") {
    val list: List[SplitTestState] = List(SplitTestState("C1", 0), SplitTestState("C2", 100))
    val splitTest = SplitTest("Name", list)
    val str = SplitTestRepository.getSplitTestValue(splitTest)
    assert(str === "C2")
  }

  test("Generate obvious response out of a two states with one being zero unordered") {
    val list: List[SplitTestState] = List(SplitTestState("C1", 100), SplitTestState("C2", 0))
    val splitTest = SplitTest("Name", list)
    val str = SplitTestRepository.getSplitTestValue(splitTest)
    assert(str === "C1")
  }

}
