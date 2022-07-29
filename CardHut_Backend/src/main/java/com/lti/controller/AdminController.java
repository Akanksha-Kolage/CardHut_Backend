package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminLoginDto;
import com.lti.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PutMapping("/activate/{emiCardNo}")
	public boolean activateCard(@PathVariable int emiCardNo) {
		return adminService.activateCard(emiCardNo);
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody AdminLoginDto adminloginData) {
		boolean isValid = adminService.adminLogin(adminloginData.getUsername(), adminloginData.getPassword());
		return isValid;
	}
	
}
