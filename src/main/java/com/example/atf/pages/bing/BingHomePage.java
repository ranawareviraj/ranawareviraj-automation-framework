package com.example.atf.pages.bing;


import com.example.atf.Constants;
import com.example.atf.pages.BasePage;
import com.example.atf.utils.ScreenshotsUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class BingHomePage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(com.example.atf.pages.google.GoogleHomePage.class);

    @Value("${applications.bing.url}")
    private String url;
    @FindBy(id = "sb_form_q")
    private WebElement searchBox;

    public BingHomePage(WebDriver webDriver, WebDriverWait wait, ScreenshotsUtil screenshotsUtil) {
        super(webDriver, wait, screenshotsUtil);
    }

    @Override
    public boolean isLoaded() {
        return webDriver.getTitle().equals(Constants.BING_HOME_TITLE);
    }

    public void goTo() {
        logger.info("Navigating to: {}", url);
        this.webDriver.get(url);
    }

    public void search(final String keyword) {
        logger.info("Searching on Bing for: {}", keyword);
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.ENTER);
        logger.info("Search performed!");
    }

}
