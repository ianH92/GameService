package gameservice.hibernate.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${spring.jpa.hibernate.ddl-auto:create}")
	private String hibernateHbm2ddl;
	
	@Value("${spring.jpa.database-platform:org.hibernate.dialect.H2Dialect}")
	private String hibernateDialect;
	
	@Value("${spring.datasource.url:jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1}")
	private String url;
	
	@Value("${spring.datasource.username:user}")
	private String username;
	
	@Value("${spring.datasource.password:password}")
	private String password;
	
	@Value("${spring.datasource.driver-class-name:org.h2.Driver}")
	private String driverClassName;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		sessionFactory.setDataSource(dataSource);
		
		sessionFactory.setPackagesToScan("gameservice.game.players");
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddl);
		hibernateProperties.setProperty("hibernate.dialect", hibernateDialect);
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
