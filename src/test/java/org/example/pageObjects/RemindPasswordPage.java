package org.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RemindPasswordPage extends BasePage{

    public RemindPasswordPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "loginOrEmail")
    private WebElement loginOrEmailField;

    @FindBy(className = "mira-page-forgot-password-button")
    private WebElement forgotPasswordBtn;

    @FindBy(className = "alert")
    private WebElement userNotFoundAlert;

    @FindBy(className = "success")
    private WebElement instructionSendedAlert;

    public void inputLoginOrEmail(String loginOrEmail){
        wait.until(ExpectedConditions.visibilityOf(loginOrEmailField));
        loginOrEmailField.sendKeys(loginOrEmail);
    }

    public void clickConfirmForgotPasswordBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordBtn));
        forgotPasswordBtn.click();
    }

    public String getUserNotFoundAlert(){
        wait.until(ExpectedConditions.visibilityOf(userNotFoundAlert));
        return userNotFoundAlert.getText();
    }

    public String getInstructionSendedAlert(){
        wait.until(ExpectedConditions.visibilityOf(instructionSendedAlert));
        return instructionSendedAlert.getText();
    }
}
