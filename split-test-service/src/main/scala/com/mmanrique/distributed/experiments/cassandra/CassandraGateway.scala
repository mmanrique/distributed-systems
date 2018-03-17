package com.mmanrique.distributed.experiments.cassandra

import com.datastax.driver.core.{Cluster, Session}
import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import scala.beans.BeanProperty

@Component
class CassandraGateway(@Value("${cassandra.location}") @BeanProperty defaultLocation: String,
                       @Value("${cassandra.keyspace-name}") @BeanProperty keySpaceName: String)
  extends LazyLogging {

  lazy val cluster: Cluster = getCluster


  def getSession: Session = {
    cluster.connect(keySpaceName)
  }

  def getCluster: Cluster = {
    logger.info("Created Cluster connection")
    Cluster.builder().addContactPoint(defaultLocation).build()
  }

}


