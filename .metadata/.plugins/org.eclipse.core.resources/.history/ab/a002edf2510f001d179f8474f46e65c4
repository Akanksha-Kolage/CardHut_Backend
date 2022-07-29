package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Transaction;
import com.lti.entity.User;
import com.lti.service.TransactionService;

@RestController
@RequestMapping("/testing")
@CrossOrigin(origins="*")
public class TransactionController {
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addTransactionOfProduct(@RequestBody Transaction transaction) {
		String message = transactionService.addTransactionOfProduct(transaction);
		return message;
	}
	
	@GetMapping("/viewAllByCardNo/{cardNo}")
	public List<Transaction> viewTransactionByCardNo(int cardNo){
		return transactionService.viewTransactionByCardNo(cardNo);
	}
	@GetMapping("/viewAllByProductId/{productId}")
	public List<Transaction> viewTransactionByProductId(int productId){
		return transactionService.viewTransactionsByProductId(productId);
	}

}
