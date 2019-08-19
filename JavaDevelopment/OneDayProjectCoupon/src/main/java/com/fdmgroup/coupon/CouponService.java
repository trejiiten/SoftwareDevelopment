package com.fdmgroup.coupon;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CouponService {

	@Autowired
	private CouponRepository repository;

	@Autowired
	private ApplicationContext ctx;

	@Transactional(readOnly = false)
	public void create(Coupon coupon) throws CouponIdDoesNotExistException {
		if (coupon.getCouponName().equals(null)) {
			throw ctx.getBean(CouponIdDoesNotExistException.class);
		} else {
			repository.save(coupon);
		}
	}

	public Coupon read(long couponId) throws CouponIdDoesNotExistException  {
		Optional<Coupon> optionalCoupon = repository.findById(couponId);
		if(optionalCoupon.isPresent()) {
			return optionalCoupon.get();
		}
		throw ctx.getBean(CouponIdDoesNotExistException.class);
	}

	@Transactional(readOnly = false)
	public void update(Coupon coupon) throws CouponIdDoesNotExistException, NoRemainingCouponsException, CouponDoesNotExistException {
		read(coupon.getCouponId());
		if(coupon.getQuantityRemaining() != 0) {
			repository.save(coupon);
		} else {
			throw ctx.getBean(NoRemainingCouponsException.class);
		
		}
	}

	@Transactional(readOnly = false)
	public void delete(long couponId) throws CouponIdDoesNotExistException, CouponDoesNotExistException {
		read(couponId);
		if (read(couponId).equals(null)) {
			throw ctx.getBean(CouponIdDoesNotExistException.class);
		} 
		repository.delete(read(couponId));
	}

	public List<Coupon> getAll() {
		return (List<Coupon>) repository.findAll();
	}

}
