package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.EmiCard;
import com.lti.entity.User;

@Repository
public class EmiCardDaoImpl implements EmiCardDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public EmiCard addOrUpdateEmiCard(EmiCard emiCard) {
		EmiCard emiCardPersisted=null;
		try {
			emiCardPersisted=em.merge(emiCard);
			return emiCardPersisted;
		} catch (Exception e) {
			return null;
		}
	}

	public EmiCard getEmiCardByUserId(int userId) {
		try {
			String jpql="select e from EmiCard e where userId=:userId";
			TypedQuery<EmiCard> query = em.createQuery(jpql, EmiCard.class);
			query.setParameter("userId", userId);
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
//		User user= new User();
	}

}
