package com.example.multiModule.common.spring.neo4j;

import com.example.multiModule.common.spring.configs.PackageConfig;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jProperties;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

@Configuration
@EnableNeo4jRepositories(
        basePackages = { "${packages.common.neo4j.repository}" },
        sessionFactoryRef = "neo4jSessionFactory",
        transactionManagerRef = "neo4jTransactionManager",
        sessionBeanName = "aSessionToInstance2")
@EntityScan(basePackages = { "${packages.common.neo4j.entity}" })
public class Neo4jConfig {

    @Autowired
    PackageConfig packageConfig;

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.neo4j")
    public Neo4jProperties neo4jProperties() {
        return new Neo4jProperties();
    }

    @Bean
    @Primary
    public org.neo4j.ogm.config.Configuration ogmConfiguration() {
        return neo4jProperties().createConfiguration();
    }

    @Bean(name = "neo4jSessionFactory")
    @Primary
    public SessionFactory sessionFactory() {
        return new SessionFactory(ogmConfiguration(), packageConfig.getCommon().getNeo4j().getEntity());
    }

    @Bean(name = "neo4jTransactionManager")
    @Primary
    public Neo4jTransactionManager neo4jTransactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
}
