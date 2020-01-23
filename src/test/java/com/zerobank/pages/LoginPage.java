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


    @FindBy(id="user_login")
    private WebElement usernameInputBox;

    @FindBy(id="user_password")
    private WebElement passwordInputBox;

    @FindBy(css = "input.btn.btn-primary")
    private WebElement signinButton;

    public void credentialsToLogin(String username, String password){
       Driver.get().get(ConfigurationReader.get("url"));
       wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_login")));
       wait.until(ExpectedConditions.visibilityOf(usernameInputBox));
       usernameInputBox.sendKeys(ConfigurationReader.get(username));
       wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_password")));
       passwordInputBox.sendKeys(ConfigurationReader.get(password));
    }
    public void clickToLogin(){
        signinButton.click();
    }


}
