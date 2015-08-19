@ready
Feature: Login feature

  Scenario: The user logs in
    Given I navigate to the Login page
    When I log in using my username and password
    Then I should be logged in

