package com.example.atf.pages.bing;

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
public class BingSearchResultsPage extends BasePage {

    @FindBy(xpath = "//ol[@id='b_results']//a[@class='tilk']")
    List<WebElement> results;

    protected BingSearchResultsPage(WebDriver webDriver, WebDriverWait wait, ScreenshotsUtil screenshotsUtil) {
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
        results.stream().findFirst().ifPresent(WebElement::click);
    }
}
