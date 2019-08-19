package com.fdmgroup.caruserregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.caruserregistration.persistence.JPAdao;
import com.fdmgroup.caruserregistration.persistence.UsernameAlreadyExists;
import com.fdmgroup.caruserregistration.pojo.User;

@Controller
public class RegisterController {
	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JPAdao userDao;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String toRegisterUser(Model model) {
		model.addAttribute("registerObj", ctx.getBean(User.class));
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(Model model, User user, @RequestParam String cPassword) {

		String regex = "(?-i)(?=^.{8,}$)((?!.*\\s)(?=.*[A-Z])(?=.*[a-z]))((?=(.*\\d){1,})|(?=(.*\\W){1,}))^.*$";
		boolean isValid = user.getPassword().matches(regex);
		boolean isValidConfirm = cPassword.matches(regex);

		if (!isValid || !isValidConfirm) {
			model.addAttribute("exception",
					"Your password must be longer than 8 characters, and it must contain UPPERCASE letters, lowercase letters, and digits.");
			return "registration";
		} else if (!user.getPassword().equals(cPassword)) {
			model.addAttribute("exception", "Your passwords must match");
			return "registration";
		} else {

			try {
				user.setPassword(encoder.encode(user.getPassword()));
				userDao.create(user);
			} catch (UsernameAlreadyExists e) {
				model.addAttribute("exception", "The username you have entered is already taken.");
				return "registration";
			}

			return "registrationConfirmation";
		}
	}
}
