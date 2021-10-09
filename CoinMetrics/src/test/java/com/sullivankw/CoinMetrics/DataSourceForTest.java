package com.sullivankw.CoinMetrics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;
import java.sql.Driver;

import static java.lang.String.format;

@Configuration
public class DataSourceForTest {

    private static final DriverManagerDataSource DATA_SOURCE = new DriverManagerDataSource();

    private static final PostgreSQLContainer POSTGRE_SQL_CONTAINER = new PostgreSQLContainer("postgres:11-alpine");

    @Bean
    @Primary
    public static DataSource dataSource() throws Throwable {
        POSTGRE_SQL_CONTAINER.start();
        setDataSourceProperties();
        return DATA_SOURCE;
    }

    @EventListener
    public void onContextClosedEvent(@SuppressWarnings("unused") ContextClosedEvent ignored) {
        POSTGRE_SQL_CONTAINER.stop();
    }


    private static void setDataSourceProperties() {
        Integer port = POSTGRE_SQL_CONTAINER.getMappedPort(5432);
        String url = format("jdbc:postgresql://localhost:%s/%s", port, POSTGRE_SQL_CONTAINER.getDatabaseName());
        DATA_SOURCE.setDriverClassName(Driver.class.getName());
        DATA_SOURCE.setUrl(url);
        DATA_SOURCE.setUsername(POSTGRE_SQL_CONTAINER.getUsername());
        DATA_SOURCE.setPassword(POSTGRE_SQL_CONTAINER.getPassword());
    }
}
