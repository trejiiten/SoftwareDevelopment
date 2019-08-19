package com.fdmgroup.coupon;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Coupon_Table")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coupon_generator")
	@SequenceGenerator(name = "coupon_generator", sequenceName = "coupon_id_sequence", allocationSize = 1)
	@Column(name = "coupon_id")
	private long couponId;
	@Column(name = "coupon_name", nullable=false)
	private String couponName;
	@Column(name = "value", nullable=false)
	private BigDecimal couponValue;
	@Column(name = "quantity_remaining", nullable=false)
	private long quantityRemaining;

	public Coupon() {
	}

	public Coupon(long couponId, String couponName, BigDecimal couponValue, long quantityRemaining) {
		this.couponId = couponId;
		this.couponName = couponName;
		this.couponValue = couponValue;
		this.quantityRemaining = quantityRemaining;
	}

	public long getCouponId() {
		return couponId;
	}

	@ManyToMany
	@JoinColumn(name = "user_id")
	public void setCouponId(long couponId) {
		this.couponId = couponId;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public BigDecimal getCouponValue() {
		return couponValue;
	}

	public void setCouponValue(BigDecimal couponValue) {
		this.couponValue = couponValue;
	}

	public long getQuantityRemaining() {
		return quantityRemaining;
	}

	public void setQuantityRemaining(long quantityRemaining) {
		this.quantityRemaining = quantityRemaining;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (couponId ^ (couponId >>> 32));
		result = prime * result + ((couponName == null) ? 0 : couponName.hashCode());
		result = prime * result + ((couponValue == null) ? 0 : couponValue.hashCode());
		result = prime * result + (int) (quantityRemaining ^ (quantityRemaining >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coupon other = (Coupon) obj;
		if (couponId != other.couponId)
			return false;
		if (couponName == null) {
			if (other.couponName != null)
				return false;
		} else if (!couponName.equals(other.couponName))
			return false;
		if (couponValue == null) {
			if (other.couponValue != null)
				return false;
		} else if (!couponValue.equals(other.couponValue))
			return false;
		if (quantityRemaining != other.quantityRemaining)
			return false;
		return true;
	}

}
