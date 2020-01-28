package com.luxoft.javabdd.bank.junit;

import com.luxoft.javabdd.bank.BusinessCreditOfficer;
import com.luxoft.javabdd.bank.CreditOffer;
import com.luxoft.javabdd.bank.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BusinessCreditOfficerTest {

    CreditOffer sut;

    @BeforeEach
    void setup() {
        sut = new BusinessCreditOfficer("2", "Business");
    }

    @Test
    public void shouldAddNonVipCustomer() {
        Customer mike = new Customer("Mike", false);
        boolean resultOfAddOperation = sut.addCustomer(mike);

        assertAll("customer should not be added",
                () -> assertEquals(false, resultOfAddOperation),
                () -> assertEquals(0, sut.getCustomersList().size())
        );
    }

    @Test
    public void shouldAddVipCustomer() {
        Customer john = new Customer("John", true);
        boolean resultOfAddOperation = sut.addCustomer(john);

        assertAll("customer was not added successfully",
                () -> assertEquals(true, resultOfAddOperation),
                () -> assertEquals(1, sut.getCustomersList().size()),
                () -> assertEquals(john, sut.getCustomersList().get(0))
        );
    }

    @Test
    void shouldNotRemoveVipCustomers() {
        Customer john = new Customer("John", true);
        sut.addCustomer(john);

        boolean resultOfRemoveOperation = sut.removeCustomer(john);

        assertAll("customer should be removed",
                () -> assertEquals(false, resultOfRemoveOperation, "customer removed by business credit officer"),
                () -> assertEquals(1, sut.getCustomersList().size())
        );
    }

}
