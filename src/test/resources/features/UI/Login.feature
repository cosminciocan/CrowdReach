@ready
Feature: Login feature

  Background: Check If logged in
    Given I check if I am logged in
    And I log out

  @sanity
  Scenario: The user logs in
    Given I navigate to the Login page
    When I log in using my username and password
    Then I should be logged in
    And I log out

  Scenario: Access diferent pages will redirect to the log in page
    Given I navigate to the Add Contacts Manually page
    Then I should see the login page
    When I navigate to the Import From CSV page
    Then I should see the login page
    When I navigate to the Edit Business Profile page
    Then I should see the login page
    When I navigate to the Edit User Profile page
    Then I should see the login page
    When I navigate to the Edit Business Profile page
    Then I should see the login page

  Scenario: Login with incorrect username and/or password
    Given I navigate to the Login page
    When I enter an incorrect Username
    Then I should see an error message
    And I enter an incorrect password for a valid user
    Then I should see an error message

