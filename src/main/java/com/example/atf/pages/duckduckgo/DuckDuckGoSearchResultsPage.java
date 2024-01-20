package com.example.atf.pages.duckduckgo;

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
public class DuckDuckGoSearchResultsPage extends BasePage {

    @FindBy(xpath = "//li[@data-layout='organic']//h2/a")
    List<WebElement> results;

    protected DuckDuckGoSearchResultsPage(WebDriver webDriver, WebDriverWait wait, ScreenshotsUtil screenshotsUtil) {
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
