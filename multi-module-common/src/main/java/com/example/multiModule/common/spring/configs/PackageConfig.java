package com.example.multiModule.common.spring.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "packages")
public class PackageConfig {

	private Common common = new Common();

	@Data
	@NoArgsConstructor
	public class Common {
		private String component;
		private Postgres postgres = new Postgres();
		private Mongo mongo = new Mongo();
		private Neo4j neo4j = new Neo4j();
		private Cassandra cassandra = new Cassandra();
	}
	
	@Data
	@NoArgsConstructor
	public class Postgres {
		private String entity;
		private String repository;
	}
	
	@Data
	@NoArgsConstructor
	public class Mongo {
		private String entity;
		private String repository;
	}

	@Data
	@NoArgsConstructor
	public class Neo4j {
		private String entity;
		private String repository;
	}

	@Data
	@NoArgsConstructor
	public class Cassandra {
		private String entity;
		private String repository;
	}
}
