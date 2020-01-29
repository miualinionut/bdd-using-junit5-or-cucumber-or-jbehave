package com.luxoft.javabdd.bank.bdd.cucumber;

import com.luxoft.javabdd.bank.BusinessCreditOffer;
import com.luxoft.javabdd.bank.CreditOffer;
import com.luxoft.javabdd.bank.Customer;
import com.luxoft.javabdd.bank.EconomyCreditOffer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditOfferSteps {

    CreditOffer sut;
    Customer customer;

    @Given("^there is a business credit offer$")
    public void businessCreditOffer() {
        this.sut = new BusinessCreditOffer("2", "Business");
    }

    @Given("^there is a economy credit offer$")
    public void creditOfficer() {
        this.sut = new EconomyCreditOffer("1", "Economy");
    }

    @When("^we have a usual customer$")
    public void whenUsualCustomer() {
        this.customer = new Customer("Mike", false);
    }

    @When("^we have a VIP customer$")
    public void vipCustomer() {
        this.customer = new Customer("John", true);
    }

    @Then("^can add him but cannot remove him from a business credit offer$")
    public void addButNotRemove() {

    }

    @Then("^you cannot add or remove him from a business credit offer$")
    public void cannotAddOrRemove() {
        boolean resultOfAddOperation = sut.addCustomer(customer);
        boolean resultOfRemoveOperation = sut.removeCustomer(customer);

        assertAll("customer should not be added",
                () -> assertEquals(false, resultOfAddOperation),
                () -> assertEquals(false, resultOfRemoveOperation),
                () -> assertEquals(0, sut.getCustomersList().size())
        );
    }

    @Then("^you can add and remove him from an economy credit offer$")
    public void addAndRemoveCustomers() {
        boolean resultOfAddOperation = sut.addCustomer(customer);
        boolean resultOfRemoveOperation = sut.removeCustomer(customer);

        assertAll("customer was not added successfully",
                () -> assertEquals(true, resultOfAddOperation),
                () -> assertEquals(true, resultOfRemoveOperation),
                () -> assertEquals(0, sut.getCustomersList().size())
        );
    }

    @Then("^can add him but cannot remove him from an economy credit offer$")
    public void addButNotRemoveCustomers() {
        boolean resultOfAddOperation = sut.addCustomer(customer);
        boolean resultOfRemoveOperation = sut.removeCustomer(customer);

        assertAll("customer was not added successfully",
                () -> assertEquals(true, resultOfAddOperation),
                () -> assertEquals(false, resultOfRemoveOperation, "vip customer removed by economy credit officer"),
                () -> assertEquals(1, sut.getCustomersList().size()),
                () -> assertEquals(customer, sut.getCustomersList().get(0))
        );
    }
}
