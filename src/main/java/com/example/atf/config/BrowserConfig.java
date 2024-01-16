package com.example.atf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrowserConfig {

    @Value("${browser}")
    private String browser;

    public String getBrowser() {
        return browser;
    }
}

