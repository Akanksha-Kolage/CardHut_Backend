package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.TransactionDao;
import com.lti.entity.Transaction;

@Component
public class TransactionServiceimpl implements TransactionService {
	@Autowired
	TransactionDao transactionDao;

	public String addTransactionOfProduct(Transaction transaction) {
		// TODO Auto-generated method stub
		try {
		Transaction transaction2= transactionDao.addTransactionOfProduct(transaction);
		return "Transaction Completed Sucessfully. Your Transaction Id is"+transaction2.getTransactionId();
		}
		catch(Exception e) {
			return "Can't complete transaction";
		}
		
	}

	public List<Transaction> viewTransactionByCardNo(int cardNo) {
		// TODO Auto-generated method stub
		return transactionDao.viewTransactionByCardNo(cardNo);
	}

	public List<Transaction> viewTransactionsByProductId(int productId) {
		// TODO Auto-generated method stub
		return transactionDao.viewTransactionsByProductId(productId);
	}

}
