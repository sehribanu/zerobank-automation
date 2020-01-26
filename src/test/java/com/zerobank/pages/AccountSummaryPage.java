package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(Driver.get(),10);
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "h2.board-header")
    private List<WebElement> accountTypes;

    @FindBy(xpath = "(//table[@class='table'])[3]/thead/tr/th")
    private List<WebElement> creditAccountsColumns;

    private String expectedAccountSummaryTitle = "Zero - Account Summary";


    public String getActualAccountSummaryTitle(){
        String actualAccountSummaryTitle = Driver.get().getTitle();
        return actualAccountSummaryTitle;
    }
    public String getExpectedAccountSummaryTitle(){
        return expectedAccountSummaryTitle;
    }
    public List<WebElement> getAccountTypes(){
        return accountTypes;
    }

    public List<String> getStringAccountTypes(List<WebElement>accountTypes){
        List<String> stringAccountTypes = new ArrayList<>();
        for(WebElement k: accountTypes){
            stringAccountTypes.add(k.getText());
        }
        return stringAccountTypes;
    }
    public List<WebElement> getCreditAccountsColumns(){
        return creditAccountsColumns;
    }
    public List<String > getStringCreditAccountsColumns (List<WebElement> creditAccountsColumns){
        List<String> stringColumns = new ArrayList<>();
        for(WebElement k: creditAccountsColumns){
            stringColumns.add(k.getText());
        }
        return stringColumns;
    }



}
