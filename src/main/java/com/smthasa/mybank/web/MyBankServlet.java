package com.smthasa.mybank.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smthasa.mybank.context.MyBankSpringConfiguration;
import com.smthasa.mybank.model.Transaction;
import com.smthasa.mybank.service.TransactionService;

public class MyBankServlet extends HttpServlet {

    private ObjectMapper mapper;
    private TransactionService transactionService;

    @Override
    public void init() throws ServletException {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(MyBankSpringConfiguration.class);
        this.mapper = ctx.getBean(ObjectMapper.class);
        this.transactionService = ctx.getBean(TransactionService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/transactions")) {
            response.setContentType("application/json; charset=UTF-8");
            List<Transaction> transactions = transactionService.findAll();
            response.getWriter().print(mapper.writeValueAsString(transactions));
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws JsonProcessingException, IOException {
        if (request.getRequestURI().equalsIgnoreCase("/transactions")) {
            String id = request.getParameter("id");
            int amount = Integer.valueOf(request.getParameter("amount"));
            String reference = request.getParameter("reference");
            Transaction transaction = transactionService.create(id, amount, reference);
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().print(mapper.writeValueAsString(transaction));
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
