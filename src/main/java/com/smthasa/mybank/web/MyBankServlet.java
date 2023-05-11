package com.smthasa.mybank.web;

import static com.smthasa.mybank.context.Application.MAPPER;
import static com.smthasa.mybank.context.Application.TRANSACTION_SERVICE;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.smthasa.mybank.model.Transaction;

public class MyBankServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getRequestURI().equalsIgnoreCase("/transactions")) {
			response.setContentType("application/json; charset=UTF-8");
			List<Transaction> transactions = TRANSACTION_SERVICE.findAll();
			response.getWriter().print(MAPPER.writeValueAsString(transactions));
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
		if (request.getRequestURI().equalsIgnoreCase("/transactions")) {
			String id = request.getParameter("id");
			int amount = Integer.valueOf(request.getParameter("amount"));
			String reference = request.getParameter("reference");
			Transaction transaction = TRANSACTION_SERVICE.create(id, amount, reference);
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().print(MAPPER.writeValueAsString(transaction));
		} else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
	}

}
