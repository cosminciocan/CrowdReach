@ready
Feature: Testing the Registration functionality

  Background: Navigating to the web application
    Given I check if I am logged in
    And I log out

  @CRMVP-5 @CRMVP-6 @CRMVP-7 @CRMVP-9 @sanity
  Scenario: Ted wants to register
    Given I navigate to the Register page
    Given Ted wants to enter his email address
    And Ted enters a username
    And Ted wants to enter his password twice for verification
    When Ted wants to identify his business type so that the features shall be tailored to his business
    Then Ted should be able to register successfully
    And Ted should be able to log in

  Scenario: Checking the mandatory fields
    Given I navigate to the Register page
    Given I want to register
    When I forget to complete a required field
    Then I should not be allowed to continue

#  TODO: Uncomment when validations are applied
#  @CRMVP-6
#  Scenario: Check the field lenght validations
#    Then the max length validations should be as expected
