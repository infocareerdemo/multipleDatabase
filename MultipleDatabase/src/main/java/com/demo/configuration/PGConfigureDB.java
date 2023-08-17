package com.demo.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

public class PGConfigureDB {
	@Configuration
	@EnableTransactionManagement
	@EnableJpaRepositories(
	  entityManagerFactoryRef = "thirdEntityManagerFactory",
	  transactionManagerRef = "thirdTransactionManager",
	  basePackages = { "com.demo.student" }
	)
public class thirdDBConfig {
		
		@Bean(name="thirdDataSource")
		@ConfigurationProperties(prefix="spring.thirddatasource")
		public DataSource thirdDataSource() {
		    return DataSourceBuilder.create().build();
		}

		@Bean(name = "thirdEntityManagerFactory")
		public LocalContainerEntityManagerFactoryBean thirdEntityManagerFactory(EntityManagerFactoryBuilder builder,
				@Qualifier("thirdDataSource") DataSource thirdDataSource) {
			return builder
					.dataSource(thirdDataSource)
					.packages("com.demo.student")
					.build();
		}

		@Bean(name = "thirdTransactionManager")
		public PlatformTransactionManager thirdTransactionManager(
				@Qualifier("thirdEntityManagerFactory") EntityManagerFactory thirdEntityManagerFactory) {
			return new JpaTransactionManager(thirdEntityManagerFactory);
		}
}
}
