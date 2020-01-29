package com.luxoft.javabdd.bank;

public class PremiumCreditOffer extends CreditOffer {

    public PremiumCreditOffer(String id, String creditOfferType) {
        super(id, creditOfferType);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if(customer.isVip()) {
            return addToCustomersList(customer);
        }
        return false;
    }

    @Override
    public boolean removeCustomer(Customer customer) {
        return removeFromCustomersList(customer);
    }
}
