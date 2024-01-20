package com.example.atf.pages.google;

import com.example.atf.Constants;
import com.example.atf.pages.BasePage;
import com.example.atf.utils.ScreenshotsUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class GoogleHomePage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(GoogleHomePage.class);

    @Value("${applications.google.url}")
    private String url;
    @FindBy(name = "q")
    private WebElement searchBox;
    @FindBy(name = "btnK")
    private List<WebElement> searchBtns;

    public GoogleHomePage(WebDriver webDriver, WebDriverWait wait, ScreenshotsUtil screenshotsUtil) {
        super(webDriver, wait, screenshotsUtil);
    }

    @Override
    public boolean isLoaded() {
        return webDriver.getTitle().equals(Constants.GOOGLE_HOME_TITLE);
    }

    public void goTo() {
        logger.info("Navigating to: {}", url);
        this.webDriver.get(url);
    }

    public void search(final String keyword) {
        logger.info("Searching for: {}", keyword);
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.TAB);
        this.searchBtns
                .stream()
                .filter(e -> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
        logger.info("Search performed!");
    }
}
