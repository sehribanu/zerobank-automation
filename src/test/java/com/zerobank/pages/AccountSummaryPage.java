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

    private String expectedAccountSummaryTitle = "Zero - Account Summary";


    public String getActualAccountSummaryTitle(){
        String actualAccountSummaryTitle = Driver.get().getTitle();
        return actualAccountSummaryTitle;
    }
    public String getExpectedAccountSummaryTitle(){
        return expectedAccountSummaryTitle;
    }

}
