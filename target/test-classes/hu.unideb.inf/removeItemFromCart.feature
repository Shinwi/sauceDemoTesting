Feature: Remove item form cart

  Scenario: Removing one item from cart when it has two
    Given we are in the inventory page
    And the cart has two items
    When remove button is clicked on one item
    Then the cart shows 1

  Scenario: Removing one item from a cart when it has one
    Given we are in the inventory page
    And the card has one item
    When remove button is clicked on one item
    Then the cart shows no number