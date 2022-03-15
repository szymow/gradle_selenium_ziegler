@dummyQuote
Feature: Request Dummy Quote

  Scenario: Dummy data is allowed to request a quote
    Given Navigate to Page ZieglerGroup
    When User clicks on Accept all button
    Then User clicks on Request a quote button
    When User enters invalid firstname
    And User enters invalid lastname
    And User enters invalid company
    And User enters valid email
    And User enters invalid tel
    And User selects country
    And User clicks on Legal Mentions button
    Then User clicks on Submit quote contact information button
    Then User enters invalid origin
    And User enters invalid destination
    And User enters invalid description
    And User checks all checkboxes
    Then User clicks on Submit quote goods information
    Then Application shows that quote has been confirmed.