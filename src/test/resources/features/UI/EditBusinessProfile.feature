@ready
Feature: Edit Business profile feature

  Background: Login
    Given I navigate to the Login page
    And I log in using my username and password
    Then I should be logged in

  @CRMVP-16 @sanity
  Scenario: Ted wants to change details about his business (name, address, phone number, logo)
    When I navigate to the Edit Business Profile page
    And I edit my profile details
    Then the changes should be saved