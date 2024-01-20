@Bing
Feature: Bing Search

  Background:
    Given I open the bing

  @Bing_SC01
  Scenario Outline: Bing Search for <scenarioName> : '<searchText>'
    When I search on bing for '<searchText>'
    Then The page title should start with '<searchText>'
    When I click on the first bing result link
    Then The search result page should contain '<url>'
    Examples:
      | scenarioName      | searchText   | url                       |
      | Simple Search     | selenium     | https://www.selenium.dev/ |
      | Composite Word    | rest-assured | https://rest-assured.io/  |
      | Number            | 5222         | http                      |
      | Special Character | $1           | http                      |