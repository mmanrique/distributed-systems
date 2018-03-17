package com.mmanrique.distributed.experiments.cassandra

import com.datastax.driver.core.{Cluster, Session}
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import scala.beans.BeanProperty

@Component
class CassandraGateway(@Value("${cassandra.location}") @BeanProperty defaultLocation: String) {


  def getSession(): Session = {
    getCluster().connect("dev")
  }

  def getCluster(address: String = defaultLocation): Cluster = {
    Cluster.builder().addContactPoint(address).build()
  }

}


