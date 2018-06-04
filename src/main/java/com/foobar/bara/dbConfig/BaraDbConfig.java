package com.foobar.bara.dbConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "baraEntityManagerFactory",
    transactionManagerRef = "baraTransactionManager", basePackages = {"com.foobar.bara.repo"})
public class BaraDbConfig {

  @Bean(name = "baraDataSource")
  @ConfigurationProperties(prefix = "bara.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "baraEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean baraEntityManagerFactory(
      EntityManagerFactoryBuilder builder, @Qualifier("baraDataSource") DataSource dataSource) {
    return builder.dataSource(dataSource).packages("com.foobar.bara.domain").persistenceUnit("bara")
        .build();
  }

  @Bean(name = "baraTransactionManager")
  public PlatformTransactionManager baraTransactionManager(
      @Qualifier("baraEntityManagerFactory") EntityManagerFactory baraEntityManagerFactory) {
    return new JpaTransactionManager(baraEntityManagerFactory);
  }

}
