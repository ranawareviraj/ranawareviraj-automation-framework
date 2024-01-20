package com.example.atf.utils;

import com.example.atf.Constants;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.nio.file.Path;

@Component
public class ScreenshotsUtil {

    @Value("${screenshots.path}")
    private String path;
    private final TakesScreenshot webDriver;

    public ScreenshotsUtil(WebDriver webDriver) {
        this.webDriver = (TakesScreenshot) webDriver;
    }

    public void takeScreenshot(String filename) {
        Path destinationPath = Path.of(path, filename + Constants.SCREENSHOT_FILE_FORMAT);

        // Ensure that the directories leading to the destination file exist
        File destinationDirectory = destinationPath.getParent().toFile();
        if (!destinationDirectory.exists()) {
            destinationDirectory.mkdirs();
        }

        try {
            FileCopyUtils.copy(webDriver.getScreenshotAs(OutputType.FILE), destinationPath.toFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
