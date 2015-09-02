@ready
Feature: Testing the Registration functionality

  Background: Navigating to the web application
    Given I navigate to the Register page

  @CRMVP-5 @CRMVP-6 @CRMVP-7 @CRMVP-9 @sanity
  Scenario: Ted wants to register
    Given Ted wants to enter his email address
    And Ted enters a username
    And Ted wants to enter his password twice for verification
    When Ted wants to identify his business type so that the features shall be tailored to his business
    Then Ted should be able to register successfully
    And Ted should be able to log in
    Then I should be logged in

  Scenario: Checking the mandatory fields
    Given I want to register
    When I forget to complete a required field
    Then I should not be allowed to continue

  @CRMVP-6
  Scenario: Check the field lenght validations
    Then the max length validations should be as expected
