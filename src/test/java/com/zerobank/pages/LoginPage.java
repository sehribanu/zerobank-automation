package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class LoginPage {
    WebDriverWait wait = new WebDriverWait(Driver.get(),10);
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(css = "[name ='user_login']")
    private WebElement usernameInputBox;

    @FindBy(css = "[name='user_password']")
    private WebElement passwordInputBox;

    @FindBy(css = "input.btn.btn-primary")
    private WebElement signinButton;

    @FindBy(css = "div.alert.alert-error")
    private WebElement errorMessage ;

    private String expectedErrorMessage = "Login and/or password are wrong.";

    public void navigateToLoginPage(){
        Driver.get().get(ConfigurationReader.get("url"));
    }
    public void credentialsToLogin(String username, String password){
       wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name ='user_login']") ));
       wait.until(ExpectedConditions.visibilityOf(usernameInputBox));
       usernameInputBox.sendKeys(ConfigurationReader.get(username));
       wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name='user_password']")));
       passwordInputBox.sendKeys(ConfigurationReader.get(password));
    }
    public void clickToLogin(){
        wait.until(ExpectedConditions.visibilityOf(signinButton));
        signinButton.click();
    }
    public String getExpectedErrorMessage(){
        return expectedErrorMessage;
    }
    public String getActualErrorMessage(){
        return errorMessage.getText();
    }

    public WebElement getUsernameInputBox() {
        return usernameInputBox;
    }

    public WebElement getPasswordInputBox() {
        return passwordInputBox;
    }
}
