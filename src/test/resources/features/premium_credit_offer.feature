Feature: Premium credit offers
  Some details about this feature

  Scenario: Adding and removing usual customers for premium credit offers
    Given there is a premium credit offer
    When we have a usual customer
    Then you cannot add or remove him from an premium credit offer

  Scenario: Adding and removing VIP customers for premium credit offers
    Given there is a premium credit offer
    When we have a VIP customer
    Then can add him and remove him from an premium credit offer