@DuckDuckGo
Feature: DuckDuckGo Search

  Background:
    Given I open the DuckDuckGo

  @DuckDuckGo_SC01
  Scenario Outline: DuckDuckGo Search for <scenarioName> : '<searchText>'
    When I search on DuckDuckGo for '<searchText>'
    Then The page title should start with '<searchText>'
    When I click on the first DuckDuckGo result link
    Then The search result page should contain '<url>'
    Examples:
      | scenarioName      | searchText   | url                       |
      | Simple Search     | selenium     | https://www.selenium.dev/ |
      | Composite Word    | rest-assured | https://rest-assured.io/  |
      | Number            | 5222         | http                      |
      | Special Character | $1           | http                      |
