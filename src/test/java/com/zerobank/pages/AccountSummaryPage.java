package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @FindBy(xpath = "//div[@class='offset2 span8']//div[1]//div[1]//table[1]//tbody[1]//tr[1]//td[1]//a[1]")
    private WebElement savingsLink;

    @FindBy(xpath = "//a[contains(text(),'Brokerage')]")
    private WebElement brokerageLink;

    @FindBy(xpath = "//a[contains(text(),'Checking')]")
    private WebElement checkingLink;

    @FindBy(xpath = "//a[contains(text(),'Credit Card')]")
    private WebElement creditCardLink;

    @FindBy(xpath = "//a[contains(text(),'Loan')]")
    private WebElement loanLink;

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
    public void clickSavingsLink(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='offset2 span8']//div[1]//div[1]//table[1]//tbody[1]//tr[1]//td[1]//a[1]")));
        savingsLink.click();
    }
    public AccountActivity clickBrokerageLink(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Brokerage')]")));
        brokerageLink.click();
        return new AccountActivity();
    }
    public AccountActivity clickCheckingLink(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Checking')]")));
        checkingLink.click();
        return new AccountActivity();
    }
    public AccountActivity clickCreditCardLink(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Credit Card')]")));
        creditCardLink.click();
        return new AccountActivity();
    }
    public AccountActivity clickLoanLink(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Loan')]")));
        loanLink.click();
        return new AccountActivity();
    }
}
