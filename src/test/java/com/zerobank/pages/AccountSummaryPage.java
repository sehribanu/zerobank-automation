package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountSummaryPage {
    WebDriverWait wait = new WebDriverWait(Driver.get(),10);
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "div.alert.alert-error")
    private WebElement errorMessage ;

    private String expectedAccountSummaryPageURL = "http://zero.webappsecurity.com/bank/account-summary.html";
    private String expectedErrorMessage = "Login and/or password are wrong.";

    public String getActualAccountSummaryPageURL(){
        String actualAccountSummaryPageURL = Driver.get().getCurrentUrl();
        return actualAccountSummaryPageURL;
    }
    public String getExpectedAccountSummaryPageURL(){
        return expectedAccountSummaryPageURL;
    }
    public String getExpectedErrorMessage(){
        return expectedErrorMessage;
    }
    public String getActualErrorMessage(){
        return errorMessage.getText();
    }
}
