package com.luxoft.javabdd.bank;

public class PremiumCreditOffer extends CreditOffer {

    public PremiumCreditOffer(String id, String creditOfferType) {
        super(id, creditOfferType);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if(customer.isVip()) {
            this.customersList.add(customer);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeCustomer(Customer customer) {
        return this.customersList.remove(customer);
    }
}
