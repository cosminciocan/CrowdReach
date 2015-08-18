@ready
Feature: Login feature

  @CRMVP-9
  Scenario: Ted logs in
    Given The user navigates to the Login page
    When Ted logs in using his email and password
    Then Ted should be logged in