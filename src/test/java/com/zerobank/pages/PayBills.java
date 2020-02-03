package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PayBills extends BasePage {

    public PayBills() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "sp_payee")
    private WebElement payeeBox;

    @FindBy(id = "sp_account")
    private WebElement accountBox;

    @FindBy(id = "sp_amount")
    private WebElement amountBox;

    @FindBy(id = "sp_date")
    private WebElement dateInput;

    @FindBy(id = "sp_description")
    private WebElement descriptionInput;

    @FindBy(id = "pay_saved_payees")
    private WebElement payButton;

    @FindBy(xpath = "//span[contains(text(),'The payment was successfully submitted.')]")
    private WebElement succesfulMessage;

    public WebElement getPayeeBox() {
        return payeeBox;
    }

    public WebElement getAccountBox() {
        return accountBox;
    }

    public WebElement getAmountBox() {
        return amountBox;
    }

    public WebElement getDateInput() {
        return dateInput;
    }

    public WebElement getDescriptionInput() {
        return descriptionInput;
    }

    public WebElement getPayButton() {
        return payButton;
    }

    public String getSuccesfulMessage() {
        String successfullPaymentMessage = succesfulMessage.getText();
        return successfullPaymentMessage;
    }
    @FindBy(xpath = "//a[contains(text(),'Add New Payee')]")
    private WebElement addNewPayeeTab;

    public void navigateToAddNewPayee(){
        addNewPayeeTab.click();
    }
    @FindBy (id = "np_new_payee_name")
    private WebElement inputPayeeName;

    @FindBy (id = "np_new_payee_address")
    private WebElement inputPayeeAddress;

    @FindBy(id = "np_new_payee_account")
    private WebElement inputPayeeAccount;

    @FindBy (id = "np_new_payee_details")
    private WebElement inputPayeeDetails;

    public WebElement getInputPayeeName() {
        return inputPayeeName;
    }

    public WebElement getInputPayeeAddress() {
        return inputPayeeAddress;
    }

    public WebElement getInputPayeeAccount() {
        return inputPayeeAccount;
    }

    public WebElement getInputPayeeDetails() {
        return inputPayeeDetails;
    }

    @FindBy(id = "add_new_payee")
    private WebElement addButton;

    public void clickAddButton(){
        addButton.click();
    }
    @FindBy(id = "alert_content")
    private WebElement alertContent;

    public String getAlertContentText(){
        String content= alertContent.getText();
        return content;
    }
    @FindBy(xpath = "//a[contains(text(),'Purchase Foreign Currency')]")
    private WebElement purchaseForeignCurrencyTab;

    public WebElement getPurchaseForeignCurrencyTab() {
        return purchaseForeignCurrencyTab;
    }

    public void clickPurchaseForeignCurrencyTab(){
        purchaseForeignCurrencyTab.click();
    }
    @FindBy(id = "pc_currency")
    private WebElement selectCurrencyTab;
    @FindBy(xpath = "//select[@id='pc_currency']//option")
    private List<WebElement> selectOptions;

    public List<String> getCurrencyText(){
        List<String> list = new ArrayList<>();
        for(int i=0; i<selectOptions.size();i++){
            list.add(selectOptions.get(i).getAttribute("innerHTML"));
        }
        return list;
    }
    @FindBy (css = "#pc_calculate_costs")
    private WebElement buttonCalculate;

    public WebElement getButtonCalculate() {
        return buttonCalculate;
    }

    public void clickButtonCalculate(){
        buttonCalculate.click();
    }
    public void selectCurrency(){
        Select select = new Select(selectCurrencyTab);
        select.selectByIndex(3);
    }

}
