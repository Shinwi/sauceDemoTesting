Feature: Homepage login test

  Background:
    Given the homepage is opened

    Scenario Outline:
      Given the '<field1>' is filled with '<parameter1>'
      And the '<field2>' is filled with value '<parameter2>'
      When the login button is clicked
      Then the '<message>' error message is shown
      Examples:
        | field1    | field2   | parameter1       | parameter2      | message                                                                  |
        | user-name | password |                  |                 | Epic sadface: Username is required                                       |
        | user-name | password | randomUserName   |                 | Epic sadface: Password is required                                       |
        | user-name | password | validUserName    | inValidPassword | Epic sadface: Username and password do not match any user in this service|
        | user-name | password | inValidUserName  | validPassword   | Epic sadface: Username and password do not match any user in this service|