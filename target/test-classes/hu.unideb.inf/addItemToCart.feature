Feature: Add one item to cart

  Background:
    Given the homepage is opened
    And correct credentials are entered
    And the login button is clicked

  Scenario: Adding one item to shopping cart
    Given we are in the inventory page
    When add to cart button is clicked in one item
    Then the cart icon shows '1'
