  Feature: Edit User Profile
  Testing the user profile changes

  Background: Login
    Given I navigate to the Login page
    And I log in using my username and password
    Then I should be logged in

  @CRMVP-10 @regression
  Scenario: Ted wants to change his password
    Given I navigate to the Edit User Profile page
    When I input the old password and set a new password
    Then I should be able to login using that password
    And I navigate to the Edit User Profile page
    Then I set the default password for the test account
    Then I should be able to login using that password
    And I do something

