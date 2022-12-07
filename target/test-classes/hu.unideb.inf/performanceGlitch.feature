Feature: Testing the performance of the login page if username is performance_glitch_user

  Background:
    Given the homepage is opened

  Scenario:
    Given the username is filled with the value 'performance_glitch_user'
    And the password field is filled with 'secret_sauce'
    Then the page url changes to this 'https://www.saucedemo.com/inventory.html' only after more than 2 seconds
