Feature: Economy credit offers
  Some details about this feature

  Scenario: Adding and removing usual customers for economy credit offers
    Given there is a economy credit offer
    When we have a usual customer
    Then you can add and remove him from an economy credit offer

  Scenario: Adding and removing VIP customers for economy credit offers
    Given there is a economy credit offer
    When we have a VIP customer
    Then can add him but cannot remove him from an economy credit offer