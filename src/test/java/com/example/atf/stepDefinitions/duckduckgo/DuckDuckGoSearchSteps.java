package com.example.atf.stepDefinitions.duckduckgo;

import com.example.atf.pages.duckduckgo.DuckDuckGoHomePage;
import com.example.atf.pages.duckduckgo.DuckDuckGoSearchResultsPage;
import com.example.atf.pages.google.GoogleHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@SpringBootTest
public class DuckDuckGoSearchSteps {

    private static final Logger logger = LoggerFactory.getLogger(GoogleHomePage.class);
    private final DuckDuckGoHomePage duckduckgoHomePage;
    private final DuckDuckGoSearchResultsPage duckduckgoSearchResultsPage;

    @Autowired
    public DuckDuckGoSearchSteps(DuckDuckGoHomePage duckduckgoHomePage, DuckDuckGoSearchResultsPage duckduckgoSearchResultsPage) {
        this.duckduckgoHomePage = duckduckgoHomePage;
        this.duckduckgoSearchResultsPage = duckduckgoSearchResultsPage;
    }

    @Given("I open the DuckDuckGo")
    public void i_open_the_duckduckgo() {
        logger.info("Navigating to duckduckgo.com");
        duckduckgoHomePage.goTo();
        Assertions.assertTrue(duckduckgoHomePage.isLoaded());
    }

    @When("I search on DuckDuckGo for {string}")
    public void i_search_for(String searchText) {
        logger.info("Searching on duckduckgo for: {}", searchText);
        duckduckgoHomePage.search(searchText);
        Assertions.assertTrue(duckduckgoSearchResultsPage.isLoaded());
    }

    @Then("I click on the first DuckDuckGo result link")
    public void click_on_the_first_result() {
        logger.info("Clicking on the first result");
        duckduckgoSearchResultsPage.clickOnFirstResult();
    }

}