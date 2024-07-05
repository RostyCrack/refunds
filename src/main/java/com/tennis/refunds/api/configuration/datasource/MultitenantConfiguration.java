package com.tennis.refunds.api.configuration.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MultitenantConfiguration {

  @Autowired
  private TenantProperties tenantProperties;

  @Bean
  public DataSource dataSource() {
    Map<Object, Object> resolvedDataSources = new HashMap<>();
    tenantProperties.getTenants().forEach((tenantId, props) -> {
      DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
      dataSourceBuilder.driverClassName(props.getDriverClassName());
      dataSourceBuilder.url(props.getUrl());
      dataSourceBuilder.username(props.getUsername());
      dataSourceBuilder.password(props.getPassword());
      resolvedDataSources.put(tenantId, dataSourceBuilder.build());
    });

    AbstractRoutingDataSource dataSource = new MultitenantDataSource();
    dataSource.setDefaultTargetDataSource(resolvedDataSources.get(tenantProperties.getDefaultTenant()));
    dataSource.setTargetDataSources(resolvedDataSources);

    dataSource.afterPropertiesSet();
    return dataSource;
  }
}
