Feature: Homepage login test with different correct credentials

  Background:
    Given the homepage is opened

  Scenario Outline:
    Given the '<field1>' is filled with the value '<parameter1>'
    And the password is filled with value 'secret_sauce'
    When the login button is clicked
    Then this '<errorMessage>' error message is shown if user is locked out
    Then the page url changes to this 'https://www.saucedemo.com/inventory.html'
    Examples:
      | field1    |  parameter1             | errorMessage                                                 |
      | user-name | standard_user           |                                                              |
      | user-name | locked_out_user         | Epic sadface: Sorry, this user has been locked out.          |
      | user-name | problem_user            |                                                              |
      | user-name | performance_glitch_user |                                                              |