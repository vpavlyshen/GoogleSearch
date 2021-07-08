@google @search

  @severity=blocker
  @tmslink=1111
  @issue=999

Feature: Scenarios feature file
  @severity=normal
  Scenario: I want to check that first search result title includes "automation" word
    Given I go to  home page
    And I search "automation" query
    When I go to first result
    Then Page title should include "automation" word

  @severity=normal
  Scenario: I want to check that some {query} present in any url on first 5 search pages
    Given I go to home
    And I  search "automation" query
    Then I am looking for "testautomationday.com"  at 5 first pages