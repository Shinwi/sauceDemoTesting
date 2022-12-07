Feature: Add two items to cart

  Background:
    Given the homepage is opened
    And correct credentials are entered
    And the login button is clicked

  Scenario: Adding two items to shopping cart
    Given we are in the inventory page
    When add to cart button is clicked on two items
    Then the cart icon shows '2'