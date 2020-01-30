Feature: Bonus points
  Some details about this feature

  Scenario: calculate bonus points for business credit offer
    Given there is a business credit offer
    And we have a VIP customer
    When you add customer to credit offer
    Then customer should be available in credit offer customerList
    And bonus points should be 5

  Scenario: calculate bonus points for economy credit offer
    Given there is a economy credit offer
    And we have a usual customer
    When you add customer to credit offer
    Then customer should be available in credit offer customerList
    And bonus points should be 10