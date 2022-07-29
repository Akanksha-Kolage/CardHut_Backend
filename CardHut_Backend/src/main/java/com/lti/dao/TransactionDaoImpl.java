package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.entity.Transaction;
import com.lti.entity.User;

@Repository
public class TransactionDaoImpl implements TransactionDao {
	@PersistenceContext
	EntityManager em;
    
	@Transactional
	public Transaction addTransactionOfProduct(Transaction transaction) {
		// TODO Auto-generated method stub
		Transaction persistedTransaction=em.merge(transaction);
		return persistedTransaction;
	}

	public List<Transaction> viewTransactionByCardNo(int cardNo) {
		// TODO Auto-generated method stub
		String jpql = "select t from Transaction t where t.cardNo=:cno ";
		TypedQuery<Transaction> query = em.createQuery(jpql, Transaction.class);
		query.setParameter("cno", cardNo);
		return query.getResultList();
	}

	public List<Transaction> viewTransactionsByProductId(int productId) {
		// TODO Auto-generated method stub
		String jpql = "select t from Transaction t where t.productId=:pid ";
		TypedQuery<Transaction> query = em.createQuery(jpql, Transaction.class);
		query.setParameter("pid", productId);
		return query.getResultList();
	}

}
