package com.luxoft.javabdd.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    @Nested
    @DisplayName("Given there is a business credit offer")
    class BusinessCreditOfficerTest {
        CreditOffer sut;
        @BeforeEach
        void setup() {
            sut = new BusinessCreditOfficer("2", "Business");
        }

        @Nested
        @DisplayName("When we have a VIP customer")
        class VipCustomer {
            @Test
            @DisplayName("Then you can add him but cannot remove him from a business credit offer")
            public void test() {
                Customer john = new Customer("John", true);
                boolean resultOfAddOperation = sut.addCustomer(john);
                boolean resultOfRemoveOperation = sut.removeCustomer(john);

                assertAll("customer was not added successfully",
                        () -> assertEquals(true, resultOfAddOperation, "vip customer not sucessfully added by business credit officer"),
                        () -> assertEquals(false, resultOfRemoveOperation, "customer removed by business credit officer"),
                        () -> assertEquals(1, sut.getCustomersList().size()),
                        () -> assertEquals(john, sut.getCustomersList().get(0))
                );
            }
        }

        @Nested
        @DisplayName("When we have a usual customer")
        class UsualCustomer {
            @Test
            @DisplayName("Then you cannot add or remove him from a business credit offer")
            public void test() {
                Customer mike = new Customer("Mike", false);
                boolean resultOfAddOperation = sut.addCustomer(mike);
                boolean resultOfRemoveOperation = sut.removeCustomer(mike);

                assertAll("customer should not be added",
                        () -> assertEquals(false, resultOfAddOperation),
                        () -> assertEquals(false, resultOfRemoveOperation),
                        () -> assertEquals(0, sut.getCustomersList().size())
                );
            }
        }

    }

    @Nested
    @DisplayName("Given there is a economy credit offer")
    class EconomyCreditOfficerTest {

        CreditOffer sut;
        @BeforeEach
        void setup() {
            sut = new EconomyCreditOfficer("1", "Economy");
        }

        @Nested
        @DisplayName("When we have a VIP customer")
        class VipCustomer {
            @Test
            @DisplayName("Then you can add him but cannot remove him from an economy credit offer")
            public void test() {
                Customer john = new Customer("John", true);
                boolean resultOfAddOperation = sut.addCustomer(john);
                boolean resultOfRemoveOperation = sut.removeCustomer(john);

                assertAll("customer was not added successfully",
                        () -> assertEquals(true, resultOfAddOperation),
                        () -> assertEquals(false, resultOfRemoveOperation, "vip customer removed by economy credit officer"),
                        () -> assertEquals(1, sut.getCustomersList().size()),
                        () -> assertEquals(john, sut.getCustomersList().get(0))
                );
            }
        }

        @Nested
        @DisplayName("When we have a usual customer")
        class UsualCustomer {
            @Test
            @DisplayName("Then you can add and remove him from an economy credit offer")
            public void test() {
                Customer mike = new Customer("Mike", false);
                boolean resultOfAddOperation = sut.addCustomer(mike);
                boolean resultOfRemoveOperation = sut.removeCustomer(mike);

                assertAll("customer was not added successfully",
                        () -> assertEquals(true, resultOfAddOperation),
                        () -> assertEquals(true, resultOfRemoveOperation),
                        () -> assertEquals(0, sut.getCustomersList().size())
                );
            }
        }

    }
}
