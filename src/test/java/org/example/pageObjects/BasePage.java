package org.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public static void setupDriver(WebDriver webDriver){
        driver = webDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
}
