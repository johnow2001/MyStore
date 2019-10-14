Feature: Add to cart


  Scenario: Add most expensive dress to cart, log out and log back in and verify item is in cart
    Given I am on the mystore home page
    When I click on sign in
    When I enter "dummy@yahoo.co.uk" with "DUMMY"
    When I click on Dresses
    When I find the most expensive dress expected to be "$50.99" add to cart
    When I log out
    When I click on sign in
    When I enter "dummy@yahoo.co.uk" with "DUMMY"
    Then The cart displays added item

