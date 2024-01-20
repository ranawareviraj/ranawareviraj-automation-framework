package com.example.atf.stepDefinitions.google;

import com.example.atf.pages.google.GoogleHomePage;
import com.example.atf.pages.google.GoogleSearchResultsPage;
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

    private static final Logger logger = LoggerFactory.getLogger(GoogleHomePage.class);
    private final GoogleHomePage googleHomePage;
    private final GoogleSearchResultsPage googleSearchResultsPage;

    @Autowired
    public GoogleSearchSteps(GoogleHomePage googleHomePage, GoogleSearchResultsPage googleSearchResultsPage) {
        this.googleHomePage = googleHomePage;
        this.googleSearchResultsPage = googleSearchResultsPage;
    }

    @Given("I open the google")
    public void i_open_the_google() {
        logger.info("Navigating to Google.com");
        googleHomePage.goTo();
    }

    @When("I search on google for {string}")
    public void i_search_for(String searchText) {
        logger.info("Searching for: {}", searchText);
        googleHomePage.search(searchText);
        Assertions.assertTrue(googleSearchResultsPage.isLoaded());
    }

    @Then("I click on the first google search result link")
    public void click_on_the_first_result() {
        logger.info("Clicking on the first result");
        googleSearchResultsPage.clickOnFirstResult();
    }

}