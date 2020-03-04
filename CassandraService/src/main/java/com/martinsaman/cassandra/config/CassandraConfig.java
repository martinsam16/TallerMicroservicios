package com.martinsaman.cassandra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.*;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;


@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {


    @Value("${spring.data.cassandra.cluster-name}")
    private String clusterName;

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keySpaceName;

    @Value("${spring.data.cassandra.contact-points}")
    private String contactPoints;

    @Value("${spring.data.cassandra.port}")
    private int port;


    private String basePackages = "com.martinsaman.cassandra";

    @Override
    protected String getKeyspaceName() {
        return keySpaceName;
    }

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{basePackages};
    }
}
