Feature: Google Search

  Scenario Outline: Search for '<searchText>'
    Given I open the google
    When I search for '<searchText>'
    Then The page title should start with '<searchText>'
    When I Click on the first result link
    Then The search result page should contain '<url>'
    Examples:
      | searchText   | url                       |
      | selenium     | https://www.selenium.dev/ |
      | rest-assured | https://rest-assured.io/ |
