package com.luxoft.javabdd.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CreditOffer {

    private String id;
    private List<Customer> customersList = new ArrayList<Customer>();
    private String creditOfferType;

    public CreditOffer(String id, String creditOfferType) {
        this.id = id;
        this.creditOfferType = creditOfferType;
    }

    public List<Customer> getCustomersList() {
        return Collections.unmodifiableList(customersList);
    }

    protected boolean addToCustomersList(Customer customer) {
        if (this.customersList.contains(customer)) {
            return false;
        } else {
            customer.increaseCreditAmount(getCreditOfferAmount());
            return this.customersList.add(customer);
        }
    }

    protected int getCreditOfferAmount() {
    	return 100;
	}

    protected boolean removeFromCustomersList(Customer customer) {
        return this.customersList.remove(customer);
    }

    public abstract boolean addCustomer(Customer customer);

    public abstract boolean removeCustomer(Customer customer);

}
