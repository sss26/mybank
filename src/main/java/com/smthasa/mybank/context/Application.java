package com.smthasa.mybank.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smthasa.mybank.service.TransactionService;

public class Application {

    public static final ObjectMapper MAPPER = new ObjectMapper();
    public static final TransactionService TRANSACTION_SERVICE = new TransactionService();

}
