package com.luxoft.javabdd.bank.bdd.jbehave;

import com.luxoft.javabdd.bank.*;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.jupiter.api.Assertions.*;

public class BankOfferSteps {

    CreditOffer creditOffer;
    Customer customer;

    @Given("there is a business credit offer")
    public void businessCreditOffer() {
        this.creditOffer = new BusinessCreditOffer("2", "Business");
    }

    @Given("there is a economy credit offer")
    public void creditOffer() {
        this.creditOffer = new EconomyCreditOffer("1", "Economy");
    }

    @Given("there is a premium credit offer")
    public void premiumOffer() {
        this.creditOffer = new PremiumCreditOffer("3", "Premium");
    }

    @When("we have a usual customer")
    public void whenUsualCustomer() {
        this.customer = new Customer("Mike", false);
    }

    @When("we have a VIP customer")
    public void vipCustomer() {
        this.customer = new Customer("John", true);
    }

    @When("you add customer to credit offer")
    public void addCustomerToCreditOffer() {
        this.creditOffer.addCustomer(customer);
    }

    @Then("can add him but cannot remove him from a business credit offer")
    public void addButNotRemove() {
        boolean resultOfAddOperation = creditOffer.addCustomer(customer);
        boolean resultOfRemoveOperation = creditOffer.removeCustomer(customer);

        assertAll("customer was not added successfully",
                () -> assertEquals(true, resultOfAddOperation, "vip customer not sucessfully added by business credit officer"),
                () -> assertEquals(false, resultOfRemoveOperation, "customer removed by business credit officer"),
                () -> assertEquals(1, creditOffer.getCustomersList().size()),
                () -> assertEquals(customer, creditOffer.getCustomersList().get(0))
        );
    }

    @Then("you cannot add or remove him from a business credit offer")
    public void cannotAddOrRemove() {
        boolean resultOfAddOperation = creditOffer.addCustomer(customer);
        boolean resultOfRemoveOperation = creditOffer.removeCustomer(customer);

        assertAll("customer should not be added",
                () -> assertEquals(false, resultOfAddOperation),
                () -> assertEquals(false, resultOfRemoveOperation),
                () -> assertEquals(0, creditOffer.getCustomersList().size())
        );
    }

    @Then("you can add and remove him from an economy credit offer")
    public void addAndRemoveCustomers() {
        boolean resultOfAddOperation = creditOffer.addCustomer(customer);
        boolean resultOfRemoveOperation = creditOffer.removeCustomer(customer);

        assertAll("customer was not added successfully",
                () -> assertEquals(true, resultOfAddOperation),
                () -> assertEquals(true, resultOfRemoveOperation),
                () -> assertEquals(0, creditOffer.getCustomersList().size())
        );
    }

    @Then("can add him but cannot remove him from an economy credit offer")
    public void addButNotRemoveCustomers() {
        boolean resultOfAddOperation = creditOffer.addCustomer(customer);
        boolean resultOfRemoveOperation = creditOffer.removeCustomer(customer);

        assertAll("customer was not added successfully",
                () -> assertEquals(true, resultOfAddOperation),
                () -> assertEquals(false, resultOfRemoveOperation, "vip customer removed by economy credit offer"),
                () -> assertEquals(1, creditOffer.getCustomersList().size()),
                () -> assertEquals(customer, creditOffer.getCustomersList().get(0))
        );
    }

    @Then("you cannot add or remove him from an premium credit offer")
    public void cannotAddOrRemoveFromPremium() {
        boolean resultOfAddOperation = creditOffer.addCustomer(customer);
        boolean resultOfRemoveOperation = creditOffer.removeCustomer(customer);

        assertAll("customer was not added successfully",
                () -> assertEquals(false, resultOfAddOperation, "add failed"),
                () -> assertEquals(false, resultOfRemoveOperation, "remove failed"),
                () -> assertEquals(0, creditOffer.getCustomersList().size())
        );
    }

    @Then("can add him and remove him from an premium credit offer")
    public void canAddAndRemoveFromPremium() {
        boolean resultOfAddOperation = creditOffer.addCustomer(customer);
        boolean resultOfRemoveOperation = creditOffer.removeCustomer(customer);

        assertAll("customer was not added successfully",
                () -> assertEquals(true, resultOfAddOperation),
                () -> assertEquals(true, resultOfRemoveOperation),
                () -> assertEquals(0, creditOffer.getCustomersList().size())
        );
    }

    @Then("cannot add him more than once")
    public void cannotAddHimMoreThanOnce() {
        boolean resultOfAddOperation01 = creditOffer.addCustomer(customer);
        boolean resultOfAddOperation02 = creditOffer.addCustomer(customer);

        assertAll("customer was not added successfully",
                () -> assertEquals(true, resultOfAddOperation01, "first add should complete successfully"),
                () -> assertEquals(false, resultOfAddOperation02, "second add should fail"),
                () -> assertEquals(1, creditOffer.getCustomersList().size())
        );
    }

    @Then("bonus points should be (\\d+)")
    public void calculateBonusPoints(int expectedBonusPoints) {
        int customerBonusPoints = this.customer.calculateBonusPoints();
        assertEquals(expectedBonusPoints, customerBonusPoints, "bonus points not correct");
    }

    @Then("customer should be available in credit offer customerList")
    public void customerShouldBeAvailableInCreditOfferCustomerList() {
        assertTrue(this.creditOffer.getCustomersList().contains(this.customer));
    }
}
