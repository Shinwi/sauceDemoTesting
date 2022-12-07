Feature: Remove two items form cart when it has two

  Background:
    Given the homepage is opened
    And correct credentials are entered
    And the login button is clicked

  Scenario: Removing two item from a cart when it has two
    Given we are in the inventory page
    And the cart has one item
    When remove button is clicked on one item
    Then the cart icon shows no number