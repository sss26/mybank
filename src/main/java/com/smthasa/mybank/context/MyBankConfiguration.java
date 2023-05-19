package com.smthasa.mybank.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.smthasa.mybank.ApplicationLauncher;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource("classpath:/application.properties")
public class MyBankConfiguration {

    @Bean
    public ObjectMapper getObjectMapperBean() {
        return new ObjectMapper().registerModule(new JavaTimeModule());
    }

}
