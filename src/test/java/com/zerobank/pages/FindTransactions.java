package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FindTransactions extends BasePage {

    public FindTransactions(){
        PageFactory.initElements(Driver.get(),this);
    }
    WebDriverWait wait = new WebDriverWait(Driver.get(),10);

    @FindBy (xpath = "//a[contains(text(),'Find Transactions')]")
    private WebElement FindTransactionsTab;

    @FindBy (id = "aa_description")
    private WebElement inputDescription;

    @FindBy (xpath = "//div[@class='pull-right']//button")
    private WebElement buttonFind;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[2]")
    private List<WebElement> findResults;

    public WebElement getFindTransactionsTab() {
        return FindTransactionsTab;
    }

    public WebElement getInputDescription() {
        return inputDescription;
    }

    public WebElement getButtonFind() {
        return buttonFind;
    }

    public List<WebElement> getFindResults() {
        return findResults;
    }

    public List<String> getAttributeFindResults(){
        List<String> attributes = new ArrayList<>();
        for(WebElement k: findResults){
            attributes.add(k.getAttribute("innerHTML"));
        }
        return attributes;
    }
    @FindBy(id = "aa_fromDate")
    private WebElement inputDateFrom;

    @FindBy(id = "aa_toDate")
    private WebElement inputDateTo;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[1]")
    private List<WebElement> dateResults;

    public WebElement getInputDateFrom() {
        return inputDateFrom;
    }

    public WebElement getInputDateTo() {
        return inputDateTo;
    }
    public List<String> getAttributeDateResults() {
        List<String> list = new ArrayList<>();
        for (WebElement k : dateResults) {
            list.add(k.getAttribute("innerHTML"));
        }
        return list;
    }

    public List<String> getAttributeOfListResults(List<WebElement> listing){
        List<String> list=new ArrayList<>();
        for(WebElement k: listing){
            list.add(k.getAttribute("innerHTML"));
        }
        return list;
    }

    public List<String> getTextOfListResults(List<WebElement> listing){
        List<String> list=new ArrayList<>();
        for(WebElement k: listing){
            list.add(k.getText());
        }
        return list;
    }
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[3]")
    private List<WebElement> depositResults;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[4]")
    private List<WebElement> withrawalResults;

    public List<WebElement> getDepositResults() {
        return depositResults;
    }

    public List<WebElement> getWithrawalResults() {
        return withrawalResults;
    }
    public List<WebElement> selectTypeResults ( String type){
        List<WebElement> result = new ArrayList<>();

        switch (type.toLowerCase()){
            case "deposit":
                result = depositResults;
                break;
            case "withdrawal":
                result = withrawalResults;
                break;
            case "description":
                result = findResults;
                break;
            case "date":
                result = dateResults;
                break;
        }
        return result;
    }
    public List<String> attributesOfSelectTypeResults (String type){
        List<WebElement> result = new ArrayList<>();
        List<String> list = new ArrayList<>();

        switch (type.toLowerCase()){
            case "deposit":
                result = depositResults;
                break;
            case "withdrawal":
                result = withrawalResults;
                break;
            case "description":
                result = findResults;
                break;
            case "date":
                result = dateResults;
                break;
        }
        list=getAttributeOfListResults(result);
        return list;
    }

    public List<String> textsOfSelectTypeResults (String type){
        List<WebElement> result = new ArrayList<>();
        List<String> list = new ArrayList<>();

        switch (type.toLowerCase()){
            case "deposit":
                result = depositResults;
                break;
            case "withdrawal":
                result = withrawalResults;
                break;
            case "description":
                result = findResults;
                break;
            case "date":
                result = dateResults;
                break;
        }
        list=getTextOfListResults(result);
        return list;
    }
    @FindBy(xpath = "//select[@id='aa_type']")
    private WebElement selectType;

    public void selectFromType(String type){
        Select select = new Select(selectType);
        switch (type.toLowerCase()){
            case "deposit":
                select.selectByIndex(1);
                break;
            case "withdrawal":
                select.selectByIndex(2);
                break;
        }
    }
}
