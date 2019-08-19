package com.fdmgroup.alltests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fdmgroup.controllers.CouponControllerTest;
import com.fdmgroup.pojos.CouponServiceTest;
import com.fdmgroup.pojos.UserServiceTest;
import com.fdmgroup.user.UserService;

@RunWith(Suite.class)
@SuiteClasses({CouponControllerTest.class, CouponServiceTest.class, UserServiceTest.class})
public class AllTests {

}
