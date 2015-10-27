Feature: Edit User Profile
  Testing the user profile changes

  Background: Login
    Given I check if I am logged in
#    Given I log in to the CrowdReach web-app

#   Combine with register. And make a new registered user to make use of this functionality
#   It's to risky to do this test with the normal user
#  @CRMVP-10 @sanity
#  Scenario: Ted wants to change his password
#    Given I navigate to the Change Password page
#    When I input the old password and set a new password
#    Then I should be able to login using that password
#    Given I navigate to the Change Password page
#    And I set the default password for the test account
#    Then I should be able to login using that password

#  TODO: Uncomment when validations are applied
#  Scenario: Checking password max length validations
#    Given I navigate to the Edit User Profile page
#    Then I check the field max length validations

  @ready
  Scenario: Old password not correct
    Given I navigate to the Change Password page
    When I enter an incorrect old password
    Then I should see an error message regarding the old password

  @ready
  Scenario: New password to short
    Given I navigate to the Change Password page
    When I enter a new password of 7 characters
    Then I should see an error message regarding the password being to short

  @ready
  Scenario: The new and confirm password do not match
    Given I navigate to the Change Password page
    When I type the confirm password different from the new one
    Then I shouls see an error message regarding the confirm password