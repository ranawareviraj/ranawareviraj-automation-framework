package com.example.atf.stepDefinitions;

import com.example.atf.pages.google.GoogleHomePage;
import com.example.atf.utils.ScreenshotsUtil;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonSteps {

    private static final Logger logger = LoggerFactory.getLogger(GoogleHomePage.class);
    WebDriver webDriver;
    ScreenshotsUtil screenshotsUtil;

    public CommonSteps(WebDriver webDriver, ScreenshotsUtil screenshotsUtil) {
        this.webDriver = webDriver;
        this.screenshotsUtil = screenshotsUtil;
    }

    @Then("The page title should start with {string}")
    public void the_page_title_should_start_with(String searchText) {
        logger.info("Verifying page title starts with: {}", searchText);
        Assertions.assertTrue(webDriver.getTitle().startsWith(searchText));
        screenshotsUtil.takeScreenshot("SearchResultsAll");
    }

    @Then("The search result page should contain {string}")
    public void the_search_result_page_should_contain(String url) {
        logger.info("Verifying that the search result page contains: {}", url);
        String currentUrl = webDriver.getCurrentUrl();
        String message = String.format("The search result page url does not contain: %s. The actual url is: %s", url, currentUrl);
        Assertions.assertTrue(currentUrl.contains(url), message);
        screenshotsUtil.takeScreenshot("SearchResultsFirst");
    }

}
