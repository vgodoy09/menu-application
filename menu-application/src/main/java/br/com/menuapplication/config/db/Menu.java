package br.com.menuapplication.config.db;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import br.com.menuapplication.var.Constants;

@Configuration
@EnableJpaRepositories(
		basePackages = "br.com.menuapplication.repository.menu", 
		entityManagerFactoryRef = "menuEntityManager", 
		transactionManagerRef = "menuTransactionManager"
		)

public class Menu {

	@Bean
	public LocalContainerEntityManagerFactoryBean menuEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(menuDataSource());
		em.setPackagesToScan(new String[] { 
				"br.com.menuapplication.model.menu" 
		});

		HibernateJpaVendorAdapter vendorAdapter= new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		
		em.setJpaPropertyMap(properties);

		return em;
	}

	@Bean
	public DataSource menuDataSource() {
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://"+Constants.getIpDb()+"/"+Constants.getMenuDbName()+"?useSSL=false");
		dataSource.setUsername(Constants.getApplicationUser());
		dataSource.setPassword(Constants.getApplicationPassword());
		
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager menuTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(menuEntityManager().getObject());
		return transactionManager;
	}
	
	@Bean(name="menuTransactionTemplate")
	public TransactionTemplate attendanceTransactionTemplate() {
		TransactionTemplate transactionTemplate = new TransactionTemplate();
		transactionTemplate.setTransactionManager(menuTransactionManager());
		return transactionTemplate;
	}
	
}
