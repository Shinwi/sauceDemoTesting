Feature: Testing login with correct credentials

  Background:
    Given the homepage is opened

    Scenario:
      Given the username field is filled with 'standard_user'
      And the password field is filled with 'secret_sauce'
      When the login button is clicked
      Then the page url changes to 'https://www.saucedemo.com/inventory.html'