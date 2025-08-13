package com.example.citas_medicas_BE.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class DatabaseConfig {

    @Value("${DATABASE_URL:postgresql://postgres:admin@localhost:5432/citas_medicas}")
    private String databaseUrl;

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        try {
            URI dbUri = new URI(databaseUrl);
            String username = dbUri.getUserInfo() != null ? dbUri.getUserInfo().split(":")[0] : "postgres";
            String password = dbUri.getUserInfo() != null ? dbUri.getUserInfo().split(":")[1] : "admin";
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + (dbUri.getPort() != -1 ? dbUri.getPort() : 5432) + dbUri.getPath();

            return DataSourceBuilder.create()
                    .url(dbUrl)
                    .username(username)
                    .password(password)
                    .driverClassName("org.postgresql.Driver")
                    .build();
        } catch (URISyntaxException | NullPointerException e) {
            // Fallback para entorno local o CI
            return DataSourceBuilder.create()
                    .url("jdbc:postgresql://localhost:5432/citas_medicas")
                    .username("postgres")
                    .password("admin")
                    .driverClassName("org.postgresql.Driver")
                    .build();
        }
    }
}