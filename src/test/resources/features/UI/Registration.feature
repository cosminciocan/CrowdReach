@ready
Feature: Testing the Registration functionality

  Background: Navigating to the web application
    And The user navigates to the Register page

  @CRMVP-5 @CRMVP-6 @CRMVP-7
  Scenario: Ted wants to register
    Given Ted wants to enter his email address
    And Ted enters a username
    And Ted wants to enter his password twice for verification
    When Ted wants to identify his business type so that the features shall be tailored to his business
    Then Ted should be able to register successfully