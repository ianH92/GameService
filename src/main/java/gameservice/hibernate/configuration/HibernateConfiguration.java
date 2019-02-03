package gameservice.hibernate.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		sessionFactory.setDataSource(dataSource);
		
		sessionFactory.setPackagesToScan("");
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
}
