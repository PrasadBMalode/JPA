package com.xworkz.cru_Operation_Two.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.xworkz.cru_Operation_Two")

public class WebConfig {
    public WebConfig(){
        System.out.println("its configuration");
    }

    @Bean
    public ViewResolver viewResolver(){
        return new InternalResourceViewResolver("/",".jsp");
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean factoryBean=new LocalContainerEntityManagerFactoryBean();

        factoryBean.setPackagesToScan("com.xworkz.cru_Operation_Two.entity");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaProperties(properties());

        return factoryBean;
    }

    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/cru_db");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("Prasad@123");

        return driverManagerDataSource;

    }


    public Properties properties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");

        return properties;

    }
}