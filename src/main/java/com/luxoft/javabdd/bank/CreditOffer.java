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
            System.out.println(customer.getName() + " added");
            return this.customersList.add(customer);
        }
    }

    protected boolean removeFromCustomersList(Customer customer) {
		System.out.println(customer.getName() + " removed");
        return this.customersList.remove(customer);
    }

    public abstract boolean addCustomer(Customer customer);

    public abstract boolean removeCustomer(Customer customer);

}
