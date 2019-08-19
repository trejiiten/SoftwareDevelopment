package com.fdmgroup.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdmgroup.coupon.Coupon;
import com.fdmgroup.coupon.CouponService;


@Service
@Transactional(readOnly = true)
public class UserService {
	@Autowired
	private UserRepository repository;

	@Autowired
	private ApplicationContext ctx;
	
	@Transactional(readOnly = false)
	public void create(User user) throws UserDoesNotExistException {
		if (user.getFirstName().equals(null)) {
			throw ctx.getBean(UserDoesNotExistException.class);
		} else {
			repository.save(user);
		}
	}
	
	public User read(long userId) throws UserDoesNotExistException {
		Optional<User> optionalUser = repository.findById(userId);
		if (!optionalUser.isPresent()) {
			throw ctx.getBean(UserDoesNotExistException.class);
		}
		return optionalUser.get();
	}

	@Transactional(readOnly = false)
	public void update(User user) throws UserDoesNotExistException {
		read(user.getUserId());
		repository.save(user);
	}
	
	public List<Coupon> getAll() {
		List<Coupon> coupons = ctx.getBean(CouponService.class).getAll();
		for(Coupon c : coupons) {
			if(c.getQuantityRemaining() == 0) {
				coupons.remove(c);
			}
		}
		return coupons;
	}

	

	
}
