package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EMI_CARD")
public class EmiCard {
	
	@Id
	@SequenceGenerator(name="card_seq",initialValue = 2001,allocationSize = 1)
	@GeneratedValue(generator = "card_seq", strategy = GenerationType.SEQUENCE)
	private int emiCardNo;
	private String emiValidity;
	private CardType emiCardType;
	private double emiCardLimit;
	private double emiCardBalance;
	private boolean activated;
	
	//Mappings
	@OneToOne
	@JoinColumn(name="userId")
	User user;
	
	@OneToMany(mappedBy = "emiCard",cascade = CascadeType.ALL)
	List<Transaction> transactions;
	
	//Getters and Setters
	
	public int getEmiCardNo() {
		return emiCardNo;
	}

	public void setEmiCardNo(int emiCardNo) {
		this.emiCardNo = emiCardNo;
	}

	public String getEmiValidity() {
		return emiValidity;
	}

	public void setEmiValidity(String emiValidity) {
		this.emiValidity = emiValidity;
	}

	public CardType getEmiCardType() {
		return emiCardType;
	}

	public void setEmiCardType(CardType emiCardType) {
		this.emiCardType = emiCardType;
	}

	public double getEmiCardLimit() {
		return emiCardLimit;
	}

	public void setEmiCardLimit(double emiCardLimit) {
		this.emiCardLimit = emiCardLimit;
	}

	public double getEmiCardBalance() {
		return emiCardBalance;
	}

	public void setEmiCardBalance(double emiCardBalance) {
		this.emiCardBalance = emiCardBalance;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public EmiCard() {
		
	}
	
	//Parameterized Constructors
	
	public EmiCard(int emiCardNo, String emiValidity, CardType emiCardType, double emiCardLimit, double emiCardBalance,
			boolean activated, User user, List<Transaction> transactions) {
		this.emiCardNo = emiCardNo;
		this.emiValidity = emiValidity;
		this.emiCardType = emiCardType;
		this.emiCardLimit = emiCardLimit;
		this.emiCardBalance = emiCardBalance;
		this.activated = activated;
		this.user = user;
		this.transactions = transactions;
	}
	
}
