package com.luxoft.javabdd.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CreditOffer {

	protected String id;
	protected List<Customer> customersList = new ArrayList<Customer>();
	protected String creditOfferType;

	public CreditOffer(String id, String creditOfferType) {
		this.id = id;
		this.creditOfferType = creditOfferType;
	}

	public String getId() {
		return id;
	}

	public List<Customer> getCustomersList() {
		return Collections.unmodifiableList(customersList);
	}

	public String getCreditOfferType() {
		return creditOfferType;
	}

	public abstract boolean addCustomer(Customer customer);

	public abstract boolean removeCustomer(Customer customer);

}
