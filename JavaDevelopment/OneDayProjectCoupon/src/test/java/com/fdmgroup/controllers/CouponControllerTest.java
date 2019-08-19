package com.fdmgroup.controllers;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fdmgroup.config.AppConfigTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
@ActiveProfiles({ "test" })
@WebAppConfiguration
public class CouponControllerTest {

	@Autowired
	WebApplicationContext webCtx;
	MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webCtx).build();
	}

	@Test
	public void test_WhenStartingApplication_IndexIsReturned() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().is(200)).andExpect(view().name("index"))
			.andExpect(forwardedUrl("/WEB-INF/views/index.jsp"));
	}
	
	@Test
	public void test_WhenNavigatingToIndex_IndexIsReturned() throws Exception {
		mockMvc.perform(get("/index")).andExpect(status().is(200)).andExpect(view().name("index"))
			.andExpect(forwardedUrl("/WEB-INF/views/index.jsp"));
	}
	
	@Test
	public void test_WhenNavigatingToUseAllCoupons_UseCouponsPageIsReturned() throws Exception {
		mockMvc.perform(get("/useCoupon")).andExpect(status().is(200)).andExpect(view().name("useCoupon"))
			.andExpect(forwardedUrl("/WEB-INF/views/useCoupon.jsp"));
	}

}
