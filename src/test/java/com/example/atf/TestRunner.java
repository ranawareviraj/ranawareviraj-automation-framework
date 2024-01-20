package com.example.atf;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;

/**
 * This class is the entry point for Cucumber tests.
 * <p>
 * The {@code @RunWith} annotation tells JUnit to run this test class using Cucumber.
 * <p>
 * The {@code @CucumberOptions} annotation provides configuration options for this test class.
 * <p>
 * The {@code features} option tells Cucumber where to find the feature files.
 * <p>
 * The {@code glue} option tells Cucumber where to find the step definitions.
 */

@CucumberContextConfiguration
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features"
        , glue = "com/example/atf/stepDefinitions"
        , plugin = {"pretty", "html:results/test-execution-report.html"}
        ,tags = "@Google or @DuckDuckGo or @Bing"
)
public class TestRunner {
}