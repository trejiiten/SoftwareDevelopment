package com.fdmgroup.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.coupon.Coupon;
import com.fdmgroup.coupon.CouponDoesNotExistException;
import com.fdmgroup.coupon.CouponIdDoesNotExistException;
import com.fdmgroup.coupon.CouponService;
import com.fdmgroup.coupon.NoRemainingCouponsException;
import com.fdmgroup.user.User;
import com.fdmgroup.user.UserDoesNotExistException;
import com.fdmgroup.user.UserService;

@SessionAttributes({"user"})
@Controller
public class CouponController {

	@Autowired
	private ApplicationContext ctx;
	
	@Autowired
	private CouponService couponService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/",  method = RequestMethod.GET)
	public String indexPage(Model model) throws UserDoesNotExistException {
		User user = (User) ctx.getBean("joeSmith");
		model.addAttribute("user", user);
		model.addAttribute("couponList", user.getCoupons());
		return "index";
	}
	
	@RequestMapping(value = "/index",  method = RequestMethod.GET)
	public String returnToIndexPage(Model model, User user) throws UserDoesNotExistException {
		model.addAttribute("couponList", user.getCoupons());
		return "index";
	}
	
	@RequestMapping(value = "/useCoupon", method = RequestMethod.GET)
	public String goToCouponUsedPage(Model model, User user) {
		model.addAttribute("useCoupon", (Coupon) ctx.getBean("coupon"));
		model.addAttribute("couponList", user.getCoupons());
		return "useCoupon";
	}
	
	@RequestMapping(value = "/redeemCoupon", method = RequestMethod.POST)
	public String useCoupon(Model model, Coupon coupon, User user) throws NoRemainingCouponsException, CouponIdDoesNotExistException, CouponDoesNotExistException {
		coupon.setQuantityRemaining(coupon.getQuantityRemaining() - 1);
		for(Coupon c : user.getCoupons()) {
			if(c.getCouponId() == coupon.getCouponId()) {
				c.setQuantityRemaining(coupon.getQuantityRemaining());
			}
		}
		couponService.update(coupon);
		model.addAttribute("useCoupon", coupon);
		return "redeemCoupon";
	}
	
	@PostConstruct
	public void init() throws UserDoesNotExistException, CouponIdDoesNotExistException {
		Coupon coupon1 = (Coupon) ctx.getBean("couponOne");
		Coupon coupon2 = (Coupon) ctx.getBean("couponTwo");
		Coupon coupon3 = (Coupon) ctx.getBean("couponThree");
		couponService.create(coupon1);
		couponService.create(coupon2);
		couponService.create(coupon3);
		User joeSmith = (User) ctx.getBean("joeSmith");
		userService.create(joeSmith);
	}
	
}
