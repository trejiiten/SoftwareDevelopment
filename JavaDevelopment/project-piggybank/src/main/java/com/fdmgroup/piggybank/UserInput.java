package com.fdmgroup.piggybank;

import java.math.BigDecimal;

public class UserInput {
	private String currency;
	private BigDecimal amount;
	private boolean toOrFromEuro = false;

	public UserInput(String currency, BigDecimal amount, boolean toOrFromEuro) {
		this.currency = currency;
		this.amount = amount;
		this.toOrFromEuro = toOrFromEuro;
	}

	public UserInput() {
	}

	public UserInput(String currency) {
		this.currency = currency;
	}
	
	public UserInput(BigDecimal amount) {
		this.amount = amount;
	}

	public UserInput(boolean toOrFromEuro) {
		this.toOrFromEuro = toOrFromEuro;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public boolean getToOrFromEuro() {
		return toOrFromEuro;
	}

	public void setToOrFromEuro(boolean toOrFromEuro) {
		this.toOrFromEuro = toOrFromEuro;
	}

	@Override
	public String toString() {
		return "UserInput [currency=" + currency + ", amount=" + amount + "]";
	}
	
	

}
