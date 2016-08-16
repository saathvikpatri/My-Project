package com.niit.shoppingcart.config;


import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;



@Configuration //generate some xml file
@ComponentScan("com.niit.shoppingcart") //which package we have kept classes to scan
@EnableTransactionManagement //any transaction failed in between specify either rollback or save point. 

public class ApplicationContextConfiguration {
	 
    @Bean(name = "dataSource") //create bean with that name.
    public DataSource getDataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource(); //DMDS object of the class
    	dataSource.setDriverClassName("org.h2.Driver"); 
    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/niitdb"); 
    	dataSource.setUsername("Saathvik");
    	dataSource.setPassword("Saathvik");
    	
    	return dataSource;
    }
	private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	properties.put("hibernate.hbm2ddl.auto", "update");
    	return properties;
    }
	
	@Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClasses(Category.class);
    	sessionBuilder.addAnnotatedClasses(Supplier.class);
    	
    	return sessionBuilder.buildSessionFactory();
    }
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
	
  
}
