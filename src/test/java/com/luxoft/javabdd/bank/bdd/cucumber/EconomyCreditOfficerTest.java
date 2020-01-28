package com.luxoft.javabdd.bank.bdd.cucumber;

import com.luxoft.javabdd.bank.CreditOffer;
import com.luxoft.javabdd.bank.EconomyCreditOfficer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EconomyCreditOfficerTest {

    CreditOffer sut = new EconomyCreditOfficer("1", "Economy");

    @Given("^there is a economy credit offer$")
    public void creditOfficer() {

    }

    @When("^we have a usual customer$")
    public void whenUsualCustomer() {

    }

    @Then("^you can add and remove him from an economy credit offer$")
    public void addAndRemoveCustomers() {

    }

    @When("^we have a VIP customer$")
    public void vipCustomer() {

    }

    @Then("^can add him but cannot remove him from an economy credit offer$")
    public void addButNotRemoveCustomers() {

    }
}
