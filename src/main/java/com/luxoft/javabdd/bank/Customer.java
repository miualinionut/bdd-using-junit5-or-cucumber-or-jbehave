package com.luxoft.javabdd.bank;

public class Customer {

	private String name;
	private boolean vip;
	private int creditAmount = 0;

	public Customer(String name, boolean vip) {
		this.name = name;
		this.vip = vip;
	}

	public String getName() {
		return name;
	}

	public boolean isVip() {
		return vip;
	}

	public void increaseCreditAmount(int creditAmount) {
		this.creditAmount += creditAmount;
	}

	public int calculateBonusPoints() {
		if(this.isVip()) {
			return this.creditAmount / 20;
		} else {
			return this.creditAmount / 10;
		}
	}
}
