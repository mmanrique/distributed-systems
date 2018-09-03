package com.mmanrique.distributed.experiments.repository

trait SplitTestRepository {

  def getSplitTestValue(name: String, customerId: Option[String]): String

}
