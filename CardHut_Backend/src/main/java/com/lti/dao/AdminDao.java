package com.lti.dao;

import com.lti.entity.Admin;

public interface AdminDao {
	Admin addAdmin(Admin admin);
	boolean activateCard(int emiCardNo);
	boolean adminLogin(String adminUsername, String adminPassword);
}
