package com.fdmgroup.pojos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fdmgroup.config.AppConfig;
import com.fdmgroup.coupon.Coupon;
import com.fdmgroup.coupon.CouponIdDoesNotExistException;
import com.fdmgroup.coupon.CouponService;
import com.fdmgroup.coupon.NoRemainingCouponsException;
import com.fdmgroup.user.User;
import com.fdmgroup.user.UserDoesNotExistException;
import com.fdmgroup.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@ActiveProfiles({ "test" })
@WebAppConfiguration
public class UserServiceTest {

	@Autowired
	ApplicationContext ctx;
	
	@Autowired
	private User user;
	
	@Autowired
	private Coupon coupon;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CouponService couponService;
	
	List<Coupon> coupons;
	@Before
	public void setUp() throws Exception {
		coupons = new ArrayList<>();
		coupon.setCouponId(1);
		coupon.setCouponName("coupon_one");
		coupon.setCouponValue(new BigDecimal("10"));
		coupon.setQuantityRemaining(10);
		couponService.create(coupon);
		user.setUserId(1);
		user.setFirstName("Joe");
		user.setLastName("Dow");
	}

	@Test
	public void test_addingUserWithCouponsAlsoAddsCouponToDatabase() throws UserDoesNotExistException, CouponIdDoesNotExistException {
		
		coupons.add(coupon);
		
		user.setCoupons(coupons);
		userService.create(user);
		assertEquals(this.user, user);
	}
	
	@Test
	public void test_addingAnotherCouponToExistingUserInDatabase() throws UserDoesNotExistException, CouponIdDoesNotExistException {
		userService.create(user);
		Coupon coupon2 = (Coupon) ctx.getBean("coupon");
		coupon2.setCouponName("coupon_one");
		coupon2.setCouponValue(new BigDecimal("10"));
		coupon2.setQuantityRemaining(10);
		couponService.create(coupon);
		couponService.create(coupon2);
		coupons.add(coupon2);
		coupons.add(coupon);
		user.setCoupons(coupons);
		userService.update(user);
		userService.read(user.getUserId());
		assertEquals(this.user, user);
	}
	
	@Test(expected=UserDoesNotExistException.class)
	public void test_ifUserIsNullThrowUserDoesNotExistException() throws UserDoesNotExistException {
		userService.read(3);
	}
	
}
