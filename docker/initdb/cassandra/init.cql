CREATE KEYSPACE IF NOT EXISTS spring_boot_cassandra WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

USE spring_boot_cassandra;

CREATE TABLE spring_boot_cassandra.message (
   id int,
   user_login TEXT,
   content  TEXT,
   PRIMARY KEY (id))
   WITH CLUSTERING ORDER BY (id ASC);