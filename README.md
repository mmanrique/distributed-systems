Distributed Systems
===================

This project is an intent to apply some distributed systems concepts in a "Vacation Search" service.

The technologies I'm using are:
* Scala 2.12.4
* Spring Boot 2 
* Feing 
* Prometheus
* Cassandra
* Netflix Eureka

Sub Projects
-------------
### main-ui
This is the entry point for all requests, this would be the service that is visible to the public

### Eureka Server
This is a discovery server in which all other services register

### Split Test Service
This service is created to perform A/B testing. The service is responsible for returning true or false if certain feature is enabled

### Flights Service
The service responsible for performing Flight Searches.

### Commons-Serialization
This is a library used to Serialize Scala Objects

Disclaimer
----------
This is by no means a "ready-for prod" service. 