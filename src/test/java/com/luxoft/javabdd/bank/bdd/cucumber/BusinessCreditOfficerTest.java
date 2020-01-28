package com.luxoft.javabdd.bank.bdd.cucumber;

import com.luxoft.javabdd.bank.BusinessCreditOfficer;
import com.luxoft.javabdd.bank.CreditOffer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BusinessCreditOfficerTest {

    CreditOffer sut = sut = new BusinessCreditOfficer("2", "Business");

    @Given("^there is a business credit offer$")
    public void businessCreditOffer() {

    }

    @Then("^can add him but cannot remove him from a business credit offer$")
    public void addButNotRemove() {

    }

    @Then("^you cannot add or remove him from a business credit offer$")
    public void cannotAddOrRemove() {

    }
}
