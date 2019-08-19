package com.fdmgroup.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fdmgroup.coupon.Coupon;
import com.fdmgroup.coupon.CouponDoesNotExistException;
import com.fdmgroup.coupon.CouponIdDoesNotExistException;
import com.fdmgroup.coupon.CouponService;
import com.fdmgroup.coupon.NoRemainingCouponsException;
import com.fdmgroup.user.User;
import com.fdmgroup.user.UserDoesNotExistException;
import com.fdmgroup.user.UserService;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages= "com.fdmgroup")
@Import(value = { WebConfig.class, JpaConfig.class, JpaConfigTest.class })
public class AppConfig {

	@Bean
	@Scope("prototype")
	public User user() {
		return new User();
	}
	
	@Bean
	public User joeSmith() {
		List<Coupon> coupons = new ArrayList<>();
		coupons.add(couponOne());
		coupons.add(couponTwo());
		coupons.add(couponThree());
		return new User(1, "Joe","Smith", coupons);
	}
	
	@Bean
	@Scope("prototype")
	public Coupon coupon() {
		return new Coupon();
	}
	
	@Bean
	public Coupon couponOne() {
		return new Coupon(1, "Coupon one", new BigDecimal("20"), 15);
	}
	
	@Bean
	public Coupon couponTwo() {
		return new Coupon(2, "Coupon two", new BigDecimal("15"), 1);
	}
	
	@Bean
	public Coupon couponThree() {
		return new Coupon(3, "Coupon three", new BigDecimal("25"), 5);
	}
	
	@Bean
	public CouponDoesNotExistException couponDoesNotExistException() {
		return new CouponDoesNotExistException();
	}
	
	@Bean
	public CouponIdDoesNotExistException couponIdDoesNotExistException() {
		return new CouponIdDoesNotExistException();
	}
	
	@Bean
	public NoRemainingCouponsException noRemainingCouponsException() {
		return new NoRemainingCouponsException();
	}
	
	@Bean
	public UserDoesNotExistException userDoesNotExistException() {
		return new UserDoesNotExistException();
	}
	
	@Bean
	public CouponService couponService() {
		return new CouponService();
	}
	
	@Bean
	public UserService userService() {
		return new UserService();
	}
	
}
