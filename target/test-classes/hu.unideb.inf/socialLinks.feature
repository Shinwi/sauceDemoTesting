Feature: Testing the social links on the inventory page

  Background:
    Given the homepage is opened
    And correct credentials are entered
    And the login button is clicked

  Scenario Outline:
    Given the '<socialIcon>' exists in the page
    And the '<socialIcon>' icon is clicked
    Then the opened page url is equal to '<newPageUrl>'
    Examples:
      | socialIcon      |  newPageUrl                                 |
      | social_facebook | https://www.facebook.com/saucelabs          |
      | social_twitter  | https://twitter.com/saucelabs               |
      | social_linkedin | https://www.linkedin.com/company/sauce-labs/|