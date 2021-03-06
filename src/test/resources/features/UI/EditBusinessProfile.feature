@ready
Feature: Edit Business profile feature

  Background: Login
    Given I check if I am logged in

  @CRMVP-16 @sanity
  Scenario: Ted wants to change details about his business (name, address, phone number, logo)
    When I navigate to the Edit Business Profile page
    And I edit my profile details
    Then the changes should be saved

  Scenario: Checking the fields format and mandatory fields
    Given I navigate to the Edit Business Profile page
    And I check the fields format and the mandatory fields

  @CRMVP-163
  Scenario: Remove Logo Functionality
    Given I navigate to the Edit Business Profile page
    And I can delete the uploaded logo
    Then the logo chage should be saved
