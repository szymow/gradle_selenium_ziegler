@dummyContactUs
Feature: Dummy Contact Us
  Scenario: Dummy data is allowed to contact us
    Given Navigate to Page ZieglerGroup
    When User clicks on Accept all button
    Then User clicks on Contact us button
    And User enters contact email
    And User enters contact name
    And User enters contact subject
    And User selects contact country
    And User selects contact comment
    And User clicks on Privacy Policy button
    And User clicks on Submit contact button
    Then Application shows that contact has been confirmed.