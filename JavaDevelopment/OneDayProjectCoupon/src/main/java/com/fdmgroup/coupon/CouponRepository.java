package com.fdmgroup.coupon;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Long> {

	Optional<Coupon> getByCouponId(Long couponId);
}
