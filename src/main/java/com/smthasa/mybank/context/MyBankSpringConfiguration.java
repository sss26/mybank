package com.smthasa.mybank.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smthasa.mybank.service.TransactionService;

@Configuration
public class MyBankSpringConfiguration {

    @Bean
    public ObjectMapper getObjectMapperBean() {
        return new ObjectMapper();
    }

    @Bean
    public TransactionService getTransactionServiceBean() {
        return new TransactionService();
    }
}
