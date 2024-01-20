package com.example.atf.stepDefinitions.bing;

import com.example.atf.pages.bing.BingHomePage;
import com.example.atf.pages.bing.BingSearchResultsPage;
import com.example.atf.pages.google.GoogleHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@SpringBootTest
public class BingSearchSteps {

    private static final Logger logger = LoggerFactory.getLogger(GoogleHomePage.class);
    private final BingHomePage bingHomePage;
    private final BingSearchResultsPage bingSearchResultsPage;

    @Autowired
    public BingSearchSteps(BingHomePage bingHomePage, BingSearchResultsPage bingSearchResultsPage) {
        this.bingHomePage = bingHomePage;
        this.bingSearchResultsPage = bingSearchResultsPage;
    }

    @Given("I open the bing")
    public void i_open_the_bing() {
        logger.info("Navigating to Bing.com");
        bingHomePage.goTo();
    }

    @When("I search on bing for {string}")
    public void i_search_for(String searchText) {
        logger.info("Searching on bing for: {}", searchText);
        bingHomePage.search(searchText);
    }

    @Then("I click on the first bing result link")
    public void click_on_the_first_result() {
        logger.info("Clicking on the first result");
        bingSearchResultsPage.clickOnFirstResult();
    }

}