package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.EmiCard;
import com.lti.entity.User;
import com.lti.service.EmiCardService;
import com.lti.service.UserService;

//import oracle.jdbc.proxy.annotation.Post;

@RestController
@RequestMapping("/cards")
public class EmiCardController {

	@Autowired
	EmiCardService emiCardService;

	@Autowired
	UserService userService;

	@PostMapping("/addCard/{userId}")
	public String addEmiCard(@PathVariable int userId, @RequestBody EmiCard emiCard) {

		emiCard.setUser(userService.findUser(userId));
		return emiCardService.addOrUpdateEmiCard(emiCard);
	}

	@GetMapping("/viewEmiCard/{userId}")
	public EmiCard viewEmiCard(@PathVariable int userId) {
		return emiCardService.getEmiCardByUserId(21);
	}

}
