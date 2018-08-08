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
		basePackages = "br.com.menuapplication.repository.application", 
		entityManagerFactoryRef = "applicationEntityManager", 
		transactionManagerRef = "applicationTransactionManager"
		)

public class ApplicationMenu {

	@Bean
	public LocalContainerEntityManagerFactoryBean applicationEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(applicationDataSource());
		em.setPackagesToScan(new String[] { 
				"br.com.menuapplication.model.application" 
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
	public DataSource applicationDataSource() {
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://"+Constants.getIpDb()+"/"+Constants.getApplicationDbName()+"?useSSL=false");
		dataSource.setUsername(Constants.getApplicationUser());
		dataSource.setPassword(Constants.getApplicationPassword());
		
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager applicationTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(applicationEntityManager().getObject());
		return transactionManager;
	}
	
	@Bean(name="applicationTransactionTemplate")
	public TransactionTemplate attendanceTransactionTemplate() {
		TransactionTemplate transactionTemplate = new TransactionTemplate();
		transactionTemplate.setTransactionManager(applicationTransactionManager());
		return transactionTemplate;
	}
	
}
