Feature: Bank Offers for business credit officers
  Some details about this feature

  Scenario: Adding and removing VIP customers for business credit officer
    Given there is a business credit offer
    When have a VIP customer
    Then can add him but cannot remove him from a business credit offer

  Scenario: Adding and removing usual customers for business credit officer
    Given there is a business credit offer
    When we have a usual customer
    Then you cannot add or remove him from a business credit offer