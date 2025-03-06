package org.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "user")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(id = "button_submit_login_form")
    private WebElement loginButton;

    @FindBy(linkText = "Забыли пароль?")
    private WebElement forgotPassword;

    public void inputLogin(String login) {
        wait.until(ExpectedConditions.visibilityOf(loginField));
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void clickForgotPasswordBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPassword));
        forgotPassword.click();
    }
}
