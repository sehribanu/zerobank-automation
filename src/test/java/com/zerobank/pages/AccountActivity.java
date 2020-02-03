package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends BasePage {

    public AccountActivity(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(id = "aa_accountId")
    private WebElement dropDown;

    @FindBy(xpath = "//table[@class='table table-condensed table-hover']/thead/tr/th")
    private List<WebElement> columnTitles;

    @FindBy(xpath = "//option[contains(text(),'Checking')]")
    private WebElement checkingOption;

    @FindBy(xpath = "//option[contains(text(),'Savings')]")
    private WebElement savingsOption;

    @FindBy(xpath = "//option[contains(text(),'Loan')]")
    private WebElement loanOption;

    @FindBy(xpath = "//option[contains(text(),'Credit Card')]")
    private WebElement creditcardOption;

    @FindBy(xpath = "//option[contains(text(),'Brokerage')]")
    private WebElement brokerageOption;

    @FindBy(xpath = "//a[contains(text(),'Find Transactions')]")
    private WebElement findTransactionsTab;

    WebDriverWait wait = new WebDriverWait(Driver.get(),10);

    public List<String> getActualOptionsListString(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_accountId")));
        Select select = new Select(dropDown);

        List<WebElement> actualOptions = select.getOptions();
        List<String> textActualOptions = new ArrayList<>();

        for(WebElement k: actualOptions){
            textActualOptions.add(k.getText());
        }
        return textActualOptions;
    }
    public String getActualDefaultOption(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_accountId")));
        Select select = new Select(dropDown);
        String actualDefaultOption = select.getFirstSelectedOption().getText();
        return actualDefaultOption;
    }
    public List<String> getActualColumnTitles(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='table table-condensed table-hover']/thead/tr/th")));
        List<String> actualColumnTitles = new ArrayList<>();
        for(WebElement k : columnTitles){
            actualColumnTitles.add(k.getText());
        }
        return actualColumnTitles;
    }

    public WebElement getCheckingOption() {
        return checkingOption;
    }

    public WebElement getSavingsOption() {
        return savingsOption;
    }

    public WebElement getLoanOption() {
        return loanOption;
    }

    public WebElement getCreditcardOption() {
        return creditcardOption;
    }

    public WebElement getBrokerageOption() {
        return brokerageOption;
    }

    public void navigateToFindTransactions(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Find Transactions')]")));
        findTransactionsTab.click();
    }
}
