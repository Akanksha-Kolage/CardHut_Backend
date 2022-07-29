package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lti.service.AdminService;

public class AdminServiceTest {
	
	AdminService service;

	@Before
	public void initializeDao() {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/dispatcher-servlet.xml");
		service = context.getBean(AdminService.class);
	}
	
	@Test
	public void activateCardTest() {
		assertTrue(service.activateCard(2001));
	}
	
	@Test
	public void adminLoginTest() {
		boolean b = service.adminLogin("Admin", "Admin@123");
        assertTrue(b);
	}

}
