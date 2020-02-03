package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBills;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class AddNewPayeeStepDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        PayBills payBills = new PayBills();
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.withTimeout(Duration.ofSeconds(1));
        payBills.navigateToAddNewPayee();
        wait.withTimeout(Duration.ofSeconds(1));
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> datatable) {
        PayBills payBills = new PayBills();
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.withTimeout(Duration.ofSeconds(1));
        payBills.getInputPayeeName().sendKeys(datatable.get("Payee Name"));
        payBills.getInputPayeeAddress().sendKeys(datatable.get("Payee Address"));
        payBills.getInputPayeeAccount().sendKeys(datatable.get("Account"));
        payBills.getInputPayeeDetails().sendKeys(datatable.get("Payee Details"));
        payBills.clickAddButton();
        wait.withTimeout(Duration.ofSeconds(1));


    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String string) {
        PayBills payBills = new PayBills();
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.withTimeout(Duration.ofSeconds(1));
        String content = payBills.getAlertContentText();
        Assert.assertEquals(string,content);
    }

}
