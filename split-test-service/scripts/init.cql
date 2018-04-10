CREATE KEYSPACE IF NOT EXISTS dev withreplication = {'class':'SimpleStrategy','replication_factor':1};
USE dev;
CREATE TABLE dev.split_test (
    name text,
    type text,
    id uuid,
    percentage double,
    state text,
    PRIMARY KEY (name, type)
    );

INSERT INTO dev.split_test(name, type, percentage, state) VALUES (CHEAP_FLIGHTS,CONTROL,70,ACTIVE);
INSERT INTO dev.split_test(name, type, percentage, state) VALUES (CHEAP_FLIGHTS,EXPERIMENT_1,30,ACTIVE);

