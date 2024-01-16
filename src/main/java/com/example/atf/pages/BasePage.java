package com.example.atf.pages;

import com.example.atf.utils.ScreenshotsUtil;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public final WebDriver webDriver;
    public final WebDriverWait wait;
    public final ScreenshotsUtil screenshotsUtil;

    protected BasePage(WebDriver webDriver, WebDriverWait wait, ScreenshotsUtil screenshotsUtil) {
        this.webDriver = webDriver;
        this.wait = wait;
        this.screenshotsUtil = screenshotsUtil;
    }

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.webDriver, this);
    }

    public abstract boolean isLoaded();

}
