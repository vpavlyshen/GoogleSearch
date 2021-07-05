Feature: First automation test

  Scenario: I want to check that first search result title includes "automation" word
    Given I go to  home page
    And I search query
    When I go to first result
    Then Page title should include "automation" word





