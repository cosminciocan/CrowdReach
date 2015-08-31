@ready
Feature: Testing the adding of contacts

  Background: User login
    Given I navigate to the Login page
    When I log in using my username and password
    Then I should be logged in

  @CRMVP-12
  Scenario: Ted wants to enter contacts manually
    Given I navigate to the Add Contacts Manually page
    And I complete all the mandatory fields
    Then I can successfully add the contact

  @CRMVP-14
  Scenario: Ted wants to import a CSV file with contacts
    Given I navigate to the Import From CSV page
    And I upload a file
    Then I can map the fields in the file
    And I can see the values being mapped



