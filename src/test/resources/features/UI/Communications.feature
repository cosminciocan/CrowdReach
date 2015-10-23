
Feature: Communications test feature

  Background: Login
    Given I log in to the CrowdReach web-app

  @CRMVP-17 @sanity
  Scenario: Ted wants to send a one click message to his customers
    Given I navigate to the Communications Page
    When I complete the general message field with a text message
    Then the message is also written in the social media, email and text message fields
    And I log out

  Scenario Outline: Writing a message in the non-general fields does not complete the other fields
    Given I navigate to the Communications Page
    When I write a message in the "<name>" field
    Then It should not be copied in the other fields
    And I log out

    Examples:
      | name        |
      | Twitter     |
      | Facebook    |
      | Email       |
      | TextMessage |


  Scenario Outline: Writing in the general field then editing a specific field
    Given I navigate to the Communications Page
    When I complete the general message field with a text message
    Then the message is also written in the social media, email and text message fields
    When I write a message in the "<name>" field
    Then the general message should not be changed
    And I complete the general message field with a text message
    Then the specific message for the field should not be changed
    And I log out

    Examples:
      | name        |
      | Twitter     |
      | Facebook    |
      | Email       |
      | TextMessage |

