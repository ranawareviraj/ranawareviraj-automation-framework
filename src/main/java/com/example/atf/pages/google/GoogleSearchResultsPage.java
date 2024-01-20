package com.example.atf.pages.google;


import com.example.atf.pages.BasePage;
import com.example.atf.utils.ScreenshotsUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class GoogleSearchResultsPage extends BasePage {

    @FindBy(xpath = "//h3[@class='LC20lb MBeuO DKV0Md']")
    private List<WebElement> results;

    public GoogleSearchResultsPage(WebDriver webDriver, WebDriverWait wait, ScreenshotsUtil screenshotsUtil) {
        super(webDriver, wait, screenshotsUtil);
    }

    @Override
    public boolean isLoaded() {
        return this.wait.until(searchBox -> this.results.size() > 0);
    }

    public List<WebElement> getResults() {
        return results;
    }

    public void clickOnFirstResult() {
        this.results
                .stream()
                .filter(e -> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }
}
