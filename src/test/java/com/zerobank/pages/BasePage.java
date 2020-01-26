package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(id = "account_activity_tab")
    private WebElement tabAccountActivity;

    @FindBy(id = "transfer_funds_tab")
    private WebElement tabTransferFunds;

    @FindBy(id = "pay_bills_tab")
    private WebElement tabPayBills;

    @FindBy(id = "money_map_tab")
    private WebElement tabMoneyMap;

    @FindBy(id = "online_statements_tab")
    private WebElement tabOnlineStatements;

    public AccountActivity navigateToAccountActivityPage(){
        Driver.get().findElement(By.id("account_activity_tab")).click();
        return new AccountActivity();
    }
    public PayBills navigateToPayBillsPage(){
        Driver.get().findElement(By.id("pay_bills_tab")).click();
        return new PayBills();
    }


}
