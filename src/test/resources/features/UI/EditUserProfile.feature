Feature: Edit User Profile
  Testing the user profile changes

  Background: Login
    Given I log in to the CrowdReach web-app

#    todo: Uncomment this when change password is fixed
  @CRMVP-10 @sanity
  Scenario: Ted wants to change his password
    Given I navigate to the Edit User Profile page
    When I input the old password and set a new password
    And I log out
    Then I should be able to login using that password
    And I navigate to the Edit User Profile page
    Then I set the default password for the test account
    And I log out
    Then I should be able to login using that password
    And I log out

#  TODO: Uncomment when validations are applied
#  Scenario: Checking password max length validations
#    Given I navigate to the Edit User Profile page
#    Then I check the field max length validations

  Scenario: Old password not correct
    Given I navigate to the Edit User Profile page
    When I enter an incorrect old password
    Then I should see an error message regarding the old password
    And I log out

#TODO: Uncomment when validations is fixed
#  Scenario: New password to short
#    Given I navigate to the Edit User Profile page
#    When I enter a new password of 7 characters
#    Then I should see an error message regarding the password being to short
#    And I log out

  Scenario: The new and confirm password do not match
    Given I navigate to the Edit User Profile page
    When I type the confirm password different from the new one
    Then I shouls see an error message regarding the confirm password
    And I log out
