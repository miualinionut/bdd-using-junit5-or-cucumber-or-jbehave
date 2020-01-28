package com.luxoft.javabdd.bank;

public class Bank {

    public static void main(String[] args) {
        CreditOffer economyCreditOffer = new EconomyCreditOfficer("1", "Economy");
        CreditOffer businessCreditOffer = new BusinessCreditOfficer("2", "Business");

        Customer john = new Customer("John", true);
        Customer mike = new Customer("Mike", false);

        businessCreditOffer.addCustomer(john);
        businessCreditOffer.removeCustomer(john);
        businessCreditOffer.addCustomer(mike);
        economyCreditOffer.addCustomer(mike);

        System.out.println("Business credit offer customers list:");
        for (Customer customer : businessCreditOffer.getCustomersList()) {
            System.out.println(customer.getName());
        }

        System.out.println("Economy credit offer customers list:");
        for (Customer customer : economyCreditOffer.getCustomersList()) {
            System.out.println(customer.getName());
        }
    }
}
