package com.example.atf.config;

import com.example.atf.pages.google.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WebDriverConfig {

    private static final Logger logger = LoggerFactory.getLogger(WebDriverConfig.class);
    private final BrowserConfig browserConfig;


    WebDriverConfig(BrowserConfig browserConfig) {
        this.browserConfig = browserConfig;
    }

    @Bean
    @Scope("singleton")
    public WebDriver webDriver() {
        String browser = browserConfig.getBrowser().toLowerCase();
        logger.info("Launching Browser: {}", browser);
        WebDriver driver = switch (browser) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "safari" -> new SafariDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };
        logger.info("Launched Browser: {}", browser);
        driver.manage().window().maximize();
        return driver;
    }
}
