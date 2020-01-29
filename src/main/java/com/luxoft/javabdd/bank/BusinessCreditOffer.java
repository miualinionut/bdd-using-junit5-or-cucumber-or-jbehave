package com.luxoft.javabdd.bank;

public class BusinessCreditOffer extends CreditOffer {

    public BusinessCreditOffer(String id, String creditOfferType) {
        super(id, creditOfferType);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if (customer.isVip()) {
            return customersList.add(customer);
        }
        return false;
    }

    @Override
    public boolean removeCustomer(Customer customer) {
        return false;
    }
}
