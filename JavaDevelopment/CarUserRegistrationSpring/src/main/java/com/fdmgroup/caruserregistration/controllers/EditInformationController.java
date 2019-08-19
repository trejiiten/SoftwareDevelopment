package com.fdmgroup.caruserregistration.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.caruserregistration.persistence.JPAdao;
import com.fdmgroup.caruserregistration.pojo.User;

@Controller
@SessionAttributes({ "user" })
public class EditInformationController {
	@Autowired
	private ApplicationContext ctx;
	
	@Autowired
	private JPAdao userDao;
	
	@Autowired
	private PasswordEncoder encoder;

	@RequestMapping(value="/settings", method = RequestMethod.GET)
	public String returnToEditInformationPage() {
		return "settings";
	}

	@RequestMapping(value="/editInformation", method = RequestMethod.GET)
	public String toEditUserInformation(Model model) {
		return "editInformation";
	}

	@RequestMapping(value="/changePassword", method = RequestMethod.GET)
	public String toChangePassword(Model model) {
		return "changePassword";
	}
	
	@RequestMapping(value="/editInformation", method = RequestMethod.POST)
	public String editUserInformation(Model model, User user, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		userDao.update(user);
		model.addAttribute("user", user);
		return "settings";
	}

	@RequestMapping(value="/changePassword", method = RequestMethod.POST)
	public String changePassword(Model model, User user, @RequestParam String nPassword, @RequestParam String cPassword) {
		
		String regex = "(?-i)(?=^.{8,}$)((?!.*\\s)(?=.*[A-Z])(?=.*[a-z]))((?=(.*\\d){1,})|(?=(.*\\W){1,}))^.*$";
		boolean isValid = user.getPassword().matches(regex);
		boolean isValidConfirm = cPassword.matches(regex);
		if (!isValid || !isValidConfirm) {
			model.addAttribute("exception",
					"Your password must be longer than 8 characters, and it must contain UPPERCASE letters, lowercase letters, and digits.");
			return "changePassword";
		}

		if (!nPassword.equals(cPassword)) {
			model.addAttribute("exception", "Your passwords must match.");
			return "changePassword";
		} else if(user.getPassword().equals(nPassword)){
			model.addAttribute("exception", "Your new password must be different from your current password.");
			return "changePassword";
		} else {
			user.setPassword(encoder.encode(nPassword));
			userDao.update(user);
			model.addAttribute("user", user);
			return "settings";
		}
	}

}
