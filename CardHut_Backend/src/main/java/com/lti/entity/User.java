package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_Table")
public class User {
	
	
	@Id
	@SequenceGenerator(name="user_seq",initialValue = 200,allocationSize = 1)
	@GeneratedValue(generator = "user_seq", strategy = GenerationType.SEQUENCE)
	private int userId;
	private String userName;
	private String userPhone;
	private String userEmail;
	private String userUsername;
	private String userPassword;
	private String userAddress;
	private CardType cardType;
	private String userBank;
	private String userAccountNo;
	private String userIfsc;
	
	//Mappings
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	EmiCard emiCard;
	
	public User() {
		
	}
	
	//Parameterized Constructors
	
	public User(int userId, String userName, String userPhone, String userEmail, String userUsername,
			String userPassword, String userAddress, CardType cardType, String userBank, String userAccountNo,
			String userIfsc) {
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.cardType = cardType;
		this.userBank = userBank;
		this.userAccountNo = userAccountNo;
		this.userIfsc = userIfsc;
	}

	//Getters and Setters
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public String getUserBank() {
		return userBank;
	}

	public void setUserBank(String userBank) {
		this.userBank = userBank;
	}

	public String getUserAccountNo() {
		return userAccountNo;
	}

	public void setUserAccountNo(String userAccountNo) {
		this.userAccountNo = userAccountNo;
	}

	public String getUserIfsc() {
		return userIfsc;
	}

	public void setUserIfsc(String userIfsc) {
		this.userIfsc = userIfsc;
	}

}
