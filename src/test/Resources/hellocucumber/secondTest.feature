Feature: Second automation test
  Scenario: I want to check that some {query} present in any url on first 5 search pages
    Given I go to home page
    And I search some query
    Then I am looking for query at five first pages