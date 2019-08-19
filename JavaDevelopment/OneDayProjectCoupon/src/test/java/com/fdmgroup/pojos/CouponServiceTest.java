package com.fdmgroup.pojos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
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
import com.fdmgroup.coupon.CouponDoesNotExistException;
import com.fdmgroup.coupon.CouponIdDoesNotExistException;
import com.fdmgroup.coupon.CouponService;
import com.fdmgroup.coupon.NoRemainingCouponsException;
import com.fdmgroup.user.User;
import com.fdmgroup.user.UserService;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@ActiveProfiles({ "test" })
@WebAppConfiguration
public class CouponServiceTest {

	@Autowired
	ApplicationContext ctx;
	
	@Autowired
	private CouponService couponService;
	
	@Autowired
	private User user;
	
	@Autowired
	private Coupon coupon;
	
	@Autowired
	private UserService userService;
	
	@Before
	public void setUp() throws Exception {
		coupon.setCouponName("test_Coupon");
		coupon.setCouponValue(new BigDecimal("20"));
		coupon.setQuantityRemaining(5);
		couponService.create(coupon);
	}
	
	@Test
	public void test_addCouponToTheDatabase() throws CouponIdDoesNotExistException, CouponDoesNotExistException {
		Coupon coupon = couponService.read(this.coupon.getCouponId());
		assertEquals(this.coupon, coupon);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_addNullCouponToTheDatabase() throws CouponIdDoesNotExistException {
		Coupon coupon2 = (Coupon) ctx.getBean("coupon");
		couponService.create(coupon2);
		couponService.read(coupon2.getCouponId());
	}
	
	@Test
	public void test_updateChangesInformationInDatabase() throws CouponIdDoesNotExistException, NoRemainingCouponsException, CouponDoesNotExistException {
		coupon.setCouponName("Coupon_Test");
		coupon.setQuantityRemaining(2);
		couponService.update(coupon);
		Coupon result = couponService.read(coupon.getCouponId());
		assertEquals(2, result.getQuantityRemaining());
	}

	@Test(expected=NoRemainingCouponsException.class)
	public void test_updateThrowsNoRemainingCouponsException_IfQuantityIsEqualToZero() throws CouponIdDoesNotExistException, NoRemainingCouponsException, CouponDoesNotExistException {
		coupon.setCouponName("Coupon_Test");
		coupon.setQuantityRemaining(0);
		couponService.update(coupon);
		couponService.read(coupon.getCouponId());
		assertTrue(couponService.read(coupon.getCouponId()).getQuantityRemaining() == 0);
	}
	
	@Test
	public void test_removeCouponFromDatabase() throws CouponIdDoesNotExistException, CouponDoesNotExistException {
		Coupon coupon2 = (Coupon) ctx.getBean("coupon");
		coupon2.setCouponName("test");
		coupon2.setCouponValue(new BigDecimal("20"));
		coupon2.setQuantityRemaining(3);
		couponService.create(coupon2);
		couponService.delete(coupon2.getCouponId());
	}
	
	@Test
	public void test_getAllCouponsInDatabase() throws CouponIdDoesNotExistException {
		Coupon coupon2 = (Coupon) ctx.getBean("coupon");
		coupon2.setCouponName("test");
		coupon2.setCouponValue(new BigDecimal("20"));
		coupon2.setQuantityRemaining(3);
		couponService.create(coupon2);
		assertTrue(couponService.getAll().size() > 0);
	}
	
	@Test(expected=CouponIdDoesNotExistException.class)
	public void test_throwCouponIdDoesNotExistException_ifNoCouponIdInDatabase() throws CouponIdDoesNotExistException, CouponDoesNotExistException {
		couponService.read(20);
	}
	
	
	@Test(expected=NoRemainingCouponsException.class)
	public void test_IfCouponQuantityIsZero_returnNoRemainingCouponsException() throws CouponIdDoesNotExistException, NoRemainingCouponsException, CouponDoesNotExistException {
		coupon.setQuantityRemaining(0);
		couponService.update(coupon);
		Coupon coupon1 = couponService.read(coupon.getCouponId());
		assertTrue(coupon1.getQuantityRemaining() == 0);
		assertEquals(coupon1.getQuantityRemaining(), 0);
	}
	
	@Test(expected=CouponIdDoesNotExistException.class)
	public void test_removeNonExistantCouponFromDatabase_ThrowsCouponIdDoesNotExistException() throws CouponIdDoesNotExistException, CouponDoesNotExistException {
		Coupon coupon3 = (Coupon) ctx.getBean("coupon");
		couponService.delete(coupon3.getCouponId());
	}
	
	@Test
	public void test_getAllDoesNotIncludeNonExistantCoupons() {
		Coupon coupon3 = (Coupon) ctx.getBean("coupon");
		List<Coupon> allCoupons = couponService.getAll();
		assertFalse(allCoupons.contains(coupon3));
	}
	
	@Test
	public void test_getCouponFromTable() throws CouponIdDoesNotExistException {
		Coupon coupon4 = (Coupon) ctx.getBean("coupon");
		coupon4.setCouponName("new coupon");
		coupon4.setCouponValue(new BigDecimal("10"));
		coupon4.setQuantityRemaining(5);
		couponService.create(coupon4);
		assertEquals(coupon4, couponService.read(coupon4.getCouponId()));
		
	}
}
