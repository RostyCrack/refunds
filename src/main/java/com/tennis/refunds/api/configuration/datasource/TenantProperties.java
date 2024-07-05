package com.tennis.refunds.api.configuration.datasource;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "tenants.datasource")
@Getter
@Setter
public class TenantProperties {

    private String defaultTenant;
    private Map<String, TenantDataSourceProperties> tenants;

    // Getters and setters

  @Getter
    public static class TenantDataSourceProperties {
        private String url;
        private String username;
        private String password;
        private String driverClassName;

        // Getters and setters
    }
}
