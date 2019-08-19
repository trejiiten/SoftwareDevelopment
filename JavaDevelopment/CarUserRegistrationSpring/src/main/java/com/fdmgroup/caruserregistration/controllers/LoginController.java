package com.fdmgroup.caruserregistration.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fdmgroup.caruserregistration.persistence.JPAdao;
import com.fdmgroup.caruserregistration.persistence.UserDoesNotExist;
import com.fdmgroup.caruserregistration.pojo.User;

@Controller
@SessionAttributes({ "user" })
public class LoginController {
	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private JPAdao userDao;

	@Autowired
	private PasswordEncoder encoder;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String toIndex(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin(Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, User user, @RequestParam String password) {
		try {
			user = userDao.get(user.getUsername());
		} catch (UserDoesNotExist e) {
			model.addAttribute("exception", "You have entered the incorrect credentials");
			user.setPassword("");
			return "login";
		}
		if(encoder.matches(password, user.getPassword())) {
			model.addAttribute("user", user);
			return "loginConfirmation";
		} else {
			model.addAttribute("exception", "You have entered the incorrect credentials");
			user.setPassword("");
			return "login";
		}
		
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String toLoggedInHome(Model model, HttpServletRequest req) throws UserDoesNotExist {
		User user = (User) req.getSession().getAttribute("user");
		if(user != null) {
			return "home";
		}
		else {
			return "redirect:/login";
		}
	}

}
