package com.luxoft.javabdd.bank;

public class EconomyCreditOfficer extends CreditOffer {

    public EconomyCreditOfficer(String id, String creditOfferType) {
        super(id, creditOfferType);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return customersList.add(customer);
    }

    @Override
    public boolean removeCustomer(Customer customer) {
        if (customer.isVip()) {
            return false;
        } else {
            return customersList.remove(customer);
        }
    }
}
