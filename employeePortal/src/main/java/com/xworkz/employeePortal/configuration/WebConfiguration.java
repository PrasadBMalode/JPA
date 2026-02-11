package com.xworkz.employeePortal.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.employeePortal")
public class WebConfiguration {
    public WebConfiguration(){
        System.out.println("its a configuration class");
    }

    @Bean
    public ViewResolver viewResolver(){
        return new InternalResourceViewResolver("/",".jsp");
    }
}
