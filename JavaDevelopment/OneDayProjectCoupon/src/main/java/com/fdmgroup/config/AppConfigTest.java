package com.fdmgroup.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fdmgroup.coupon.Coupon;
import com.fdmgroup.coupon.CouponRepository;
import com.fdmgroup.coupon.CouponService;
import com.fdmgroup.user.User;
import com.fdmgroup.user.UserService;



@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages= "com.fdmgroup")
@Import(value = { WebConfig.class, JpaConfig.class, JpaConfigTest.class })
public class AppConfigTest {

	@Bean
	@Scope("prototype")
	public User user() {
		return Mockito.mock(User.class);
	}
	
	@Bean
	@Scope("prototype")
	public Coupon coupon() {
		return Mockito.mock(Coupon.class);
	}
	
	@Bean
	public CouponService couponService() {
		return Mockito.mock(CouponService.class);
	}
	
	@Bean
	public UserService userService() {
		return Mockito.mock(UserService.class);
	}
	
}
