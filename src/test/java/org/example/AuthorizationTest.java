package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pageObjects.BasePage;
import org.example.pageObjects.LoginPage;
import org.example.pageObjects.ProfilePage;
import org.example.pageObjects.RemindPasswordPage;
import org.example.properties.ConfigProvider;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorizationTest {

    private WebDriver driver;

    public LoginPage loginPage;
    public ProfilePage profilePage;
    public RemindPasswordPage remindPasswordPage;

    @BeforeAll
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        BasePage.setupDriver(driver);
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        remindPasswordPage = new RemindPasswordPage();
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

    @Test
    public void loginWithCorrectData_ThenCheckProfileUsername(){
        driver.get(ConfigProvider.URL);
        loginPage.inputLogin(ConfigProvider.USER_LOGIN);
        loginPage.inputPasswd(ConfigProvider.USER_PASSWORD);
        loginPage.clickLoginBtn();
        String username = profilePage.getUsername();
        assertEquals(username, ConfigProvider.USER_USERNAME);
    }

    @Test
    public void loginWithIncorrectData_ThenCheckError(){
        driver.get(ConfigProvider.URL);
        loginPage.inputLogin("incorrectData");
        loginPage.inputPasswd("incorrectPsw");
        loginPage.clickLoginBtn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        assertEquals(text, ConfigProvider.WRONG_DATA_ALERT);
        alert.accept();
    }

    @Test
    public void clickForgotPasswordButton_inputCorrectLoginOrEmail_ThenCheckSuccessAlert(){
        driver.get(ConfigProvider.URL);
        loginPage.clickForgotPasswordBtn();
        remindPasswordPage.inputLoginOrEmail(ConfigProvider.USER_LOGIN);
        remindPasswordPage.clickConfirmForgotPasswordBtn();
        String success = remindPasswordPage.getInstructionSendedAlert();
        assertEquals(success, ConfigProvider.SUCCESS_REMIND_PASSWORD_INFO);
    }

    @Test
    public void clickForgotPasswordButton_inputIncorrectLoginOrEmail_ThenCheckErrorAlert(){
        driver.get(ConfigProvider.URL);
        loginPage.clickForgotPasswordBtn();
        remindPasswordPage.inputLoginOrEmail("incorrectData");
        remindPasswordPage.clickConfirmForgotPasswordBtn();
        String error = remindPasswordPage.getUserNotFoundAlert();
        assertEquals(error, ConfigProvider.ERROR_REMIND_PASSWORD_INFO);
    }
}
