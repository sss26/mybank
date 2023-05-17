package com.smthasa.mybank.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smthasa.mybank.ApplicationStarter;

@Configuration
@ComponentScan(basePackageClasses = ApplicationStarter.class)
@PropertySource("classpath:/application.properties")
public class MyBankSpringConfiguration {

    @Bean
    public ObjectMapper getObjectMapperBean() {
        return new ObjectMapper();
    }
}
