package com.example.atf.stepDefinitions.google;

import com.example.atf.pages.google.HomePage;
import com.example.atf.pages.google.SearchResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration
@SpringBootTest
public class GoogleSearchSteps {

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);
    private final HomePage homePage;
    private final SearchResultsPage searchResultsPage;

    @Autowired
    public GoogleSearchSteps(HomePage homePage, SearchResultsPage searchResultsPage) {
        this.homePage = homePage;
        this.searchResultsPage = searchResultsPage;
    }

    @Given("I open the google")
    public void i_open_the_google() {
        logger.info("Navigating to Google.com");
        homePage.goTo();
    }

    @When("I search for {string}")
    public void i_search_for(String searchText) {
        logger.info("Searching for: {}", searchText);
        homePage.search(searchText);
    }

    @Then("The page title should start with {string}")
    public void the_page_title_should_start_with(String searchText) {
        logger.info("Verifying page title starts with: {}", searchText);
        Assertions.assertTrue(searchResultsPage.isLoaded());
        Assertions.assertTrue(searchResultsPage.webDriver.getTitle().startsWith(searchText));
        homePage.screenshotsUtil.takeScreenshot("GoogleSearchResultsAll");
    }

    @Then("I Click on the first result link")
    public void click_on_the_first_result() {
        logger.info("Clicking on the first result");
        searchResultsPage.clickOnFirstResult();
    }

    @Then("The search result page should contain {string}")
    public void the_search_result_page_should_contain(String url) {
        logger.info("Verifying that the search result page contains: {}", url);
        String currentUrl = searchResultsPage.webDriver.getCurrentUrl();
        String message = String.format("The search result page url does not contain: %s. The actual url is: %s", url, currentUrl);
        Assertions.assertEquals(currentUrl, url, message);
        homePage.screenshotsUtil.takeScreenshot("GoogleSearchResultsFirst");
    }

}