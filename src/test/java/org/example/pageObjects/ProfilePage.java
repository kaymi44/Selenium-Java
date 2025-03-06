package org.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage{

    public ProfilePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "avatar-full-name")
    private WebElement nameUsername;

    public String getUsername(){
        wait.until(ExpectedConditions.visibilityOf(nameUsername));
        return nameUsername.getText();
    }
}
