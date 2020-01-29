package com.luxoft.javabdd.bank.junit;

import com.luxoft.javabdd.bank.CreditOffer;
import com.luxoft.javabdd.bank.Customer;
import com.luxoft.javabdd.bank.EconomyCreditOffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EconomyCreditOfferTest {

    CreditOffer sut;

    @BeforeEach
    void setup() {
        sut = new EconomyCreditOffer("1", "Economy");
    }

    @Test
    public void shouldAddNonVipCustomer() {
        Customer mike = new Customer("Mike", false);
        boolean resultOfAddOperation = sut.addCustomer(mike);

        assertAll("customer was not added successfully",
                () -> assertEquals(true, resultOfAddOperation),
                () -> assertEquals(1, sut.getCustomersList().size()),
                () -> assertEquals(mike, sut.getCustomersList().get(0))
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
                () -> assertEquals(false, resultOfRemoveOperation, "vip customer removed by economy credit officer"),
                () -> assertEquals(1, sut.getCustomersList().size())
        );
    }

    @Test
    void shouldRemoveRegularCustomers() {
        Customer mike = new Customer("Mike", false);
        sut.addCustomer(mike);

        boolean resultOfRemoveOperation = sut.removeCustomer(mike);

        assertAll("customer should be removed",
                () -> assertEquals(true, resultOfRemoveOperation, "regular customer not removed by economy credit officer"),
                () -> assertEquals(0, sut.getCustomersList().size())
        );
    }
}
