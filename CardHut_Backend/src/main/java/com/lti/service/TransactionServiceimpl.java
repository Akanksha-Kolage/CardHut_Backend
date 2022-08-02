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

	public Transaction addOrUpdateTransaction(Transaction transaction) {
		try {
			Transaction updatedtransaction= transactionDao.addOrUpdateTransaction(transaction);
			return updatedtransaction;
			}
			catch(Exception e) {
				return null;
			}
	}
	
	public Transaction updateTransaction(Transaction transaction) {
		if(transaction.getEmiRemaining()!=0) {
			transaction.setEmiPaid(transaction.getEmiPaid()+1);
			transaction.setEmiRemaining(transaction.getEmiRemaining()-1);
			transaction.setPaidAmount(transaction.getPaidAmount() + (transaction.getProduct().getProductCost()/transaction.getEmiScheme()));
			transaction.setBalanceAmount(transaction.getTotalAmount()-transaction.getPaidAmount());
			return transactionDao.addOrUpdateTransaction(transaction);
		}
		else 
			transaction.setBalanceAmount(0);
			return transaction;
	}


	public List<Transaction> viewTransactionsByCardNo(int cardNo) {
		return transactionDao.viewTransactionsByCardNo(cardNo);
	}

	public Transaction viewTransactionByCardNoAndProductId(int emiCardNo, int productId) {
		return transactionDao.viewTransactionByCardNoAndProductId(emiCardNo,productId);
	}


	public List<Transaction> viewTransactionsForAdmin() {
		return transactionDao.viewTransactionsForAdmin();
	}

}
