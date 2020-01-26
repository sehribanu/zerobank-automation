package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
