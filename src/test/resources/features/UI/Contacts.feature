@ready
Feature: Testing the adding of contacts

  Background: User login
    Given I log in to the CrowdReach web-app

  @CRMVP-12 @sanity
  Scenario: Ted wants to enter contacts manually
    Given I navigate to the Add Contacts Manually page
    And I complete all the mandatory fields
    Then I can successfully add the contact

  @CRMVP-14 @sanity
  Scenario: Ted wants to import a CSV file with contacts
    Given I navigate to the Import From CSV page
    And I upload a file
    Then I can map the fields in the file
    And I can see the values being mapped

  Scenario: Check mandatory and type format fields for manual contacts import
    Given I navigate to the Add Contacts Manually page
    Then I check that all the fields are mandatory

  Scenario: The user clicks next without uploading a file
    When I navigate to the Import From CSV page
    And I try to proceed to the next step without uploading a file
    Then I should see an error and remain on the same page

  Scenario: Upload a wrong format file
    When I navigate to the Import From CSV page
    And I try to upload a file type different than CSV
    Then the file should not be uploaded



