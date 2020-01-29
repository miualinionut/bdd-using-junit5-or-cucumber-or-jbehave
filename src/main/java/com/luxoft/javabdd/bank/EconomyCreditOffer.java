package com.luxoft.javabdd.bank;

public class EconomyCreditOffer extends CreditOffer {

    public EconomyCreditOffer(String id, String creditOfferType) {
        super(id, creditOfferType);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return addToCustomersList(customer);
    }

    @Override
    public boolean removeCustomer(Customer customer) {
        if (customer.isVip()) {
            return false;
        } else {
            return removeFromCustomersList(customer);
        }
    }
}
