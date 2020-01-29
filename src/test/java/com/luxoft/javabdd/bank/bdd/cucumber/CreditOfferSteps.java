package com.luxoft.javabdd.bank.bdd.cucumber;

import com.luxoft.javabdd.bank.*;
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
    public void creditOffer() {
        this.sut = new EconomyCreditOffer("1", "Economy");
    }

    @Given("^there is a premium credit offer$")
    public void premiumOffer() {
        this.sut = new PremiumCreditOffer("3", "Premium");
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
        boolean resultOfAddOperation = sut.addCustomer(customer);
        boolean resultOfRemoveOperation = sut.removeCustomer(customer);

        assertAll("customer was not added successfully",
                () -> assertEquals(true, resultOfAddOperation, "vip customer not sucessfully added by business credit officer"),
                () -> assertEquals(false, resultOfRemoveOperation, "customer removed by business credit officer"),
                () -> assertEquals(1, sut.getCustomersList().size()),
                () -> assertEquals(customer, sut.getCustomersList().get(0))
        );
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
                () -> assertEquals(false, resultOfRemoveOperation, "vip customer removed by economy credit offer"),
                () -> assertEquals(1, sut.getCustomersList().size()),
                () -> assertEquals(customer, sut.getCustomersList().get(0))
        );
    }

    @Then("^you cannot add or remove him from an premium credit offer$")
    public void cannotAddOrRemoveFromPremium() {
        boolean resultOfAddOperation = sut.addCustomer(customer);
        boolean resultOfRemoveOperation = sut.removeCustomer(customer);

        assertAll("customer was not added successfully",
                () -> assertEquals(false, resultOfAddOperation, "add failed"),
                () -> assertEquals(false, resultOfRemoveOperation, "remove failed"),
                () -> assertEquals(0, sut.getCustomersList().size())
        );
    }

    @Then("^can add him and remove him from an premium credit offer$")
    public void canAddAndRemoveFromPremium() {
        boolean resultOfAddOperation = sut.addCustomer(customer);
        boolean resultOfRemoveOperation = sut.removeCustomer(customer);

        assertAll("customer was not added successfully",
                () -> assertEquals(true, resultOfAddOperation),
                () -> assertEquals(true, resultOfRemoveOperation),
                () -> assertEquals(0, sut.getCustomersList().size())
        );
    }

    @Then("^cannot add him more than once$")
    public void cannotAddHimMoreThanOnce() {
        boolean resultOfAddOperation01 = sut.addCustomer(customer);
        boolean resultOfAddOperation02 = sut.addCustomer(customer);

        assertAll("customer was not added successfully",
                () -> assertEquals(true, resultOfAddOperation01, "first add should complete successfully"),
                () -> assertEquals(false, resultOfAddOperation02, "second add should fail"),
                () -> assertEquals(1, sut.getCustomersList().size())
        );
    }
}
