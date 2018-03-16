package com.mmanrique.distributed.experiments.cassandra

import com.datastax.driver.core.{Cluster, Session}
import org.springframework.stereotype.Component

@Component
class CassandraGateway {

  def getSession(): Session = {
    getCluster().connect("dev")
  }

  def getCluster(address: String = "127.0.0.1"): Cluster = {
    Cluster.builder().addContactPoint(address).build()
  }

}


