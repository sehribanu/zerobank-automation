package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBills;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PayBillsStepDefs {



    @Given("the user navigates to Pay Bills Page")
    public void the_user_navigates_to_Pay_Bills_Page() {
        PayBills payBills = new PayBills();
        payBills.navigateToPayBillsPage();
        String expectedPageTitle = "Zero - Pay Bills";
        Assert.assertEquals(expectedPageTitle, Driver.get().getTitle());
    }

    @When("the user selects {string} as payee")
    public void the_user_selects_as_payee(String string) {
        PayBills payBills = new PayBills();
        payBills.getPayeeBox().sendKeys(string);
    }

    @When("the user selects {string} as account")
    public void the_user_selects_as_account(String string) {
        PayBills payBills = new PayBills();
        Select select = new Select(payBills.getAccountBox());
        select.selectByValue("4");
    }

    @When("the user types down {string} as amount")
    public void the_user_types_down_as_amount(String string) {
        PayBills payBills = new PayBills();
        payBills.getAmountBox().sendKeys(string);
    }

    @When("the user select {string} as date")
    public void the_user_select_as_date(String string) {
        PayBills payBills = new PayBills();
        payBills.getDateInput().sendKeys(string);
    }

    @When("the user writes down {string} as description")
    public void the_user_writes_down_as_description(String string) {
        PayBills payBills = new PayBills();
        payBills.getDescriptionInput().sendKeys(string);
    }

    @When("the user clicks the Pay button")
    public void the_user_clicks_the_Pay_button() {
        PayBills payBills = new PayBills();
        payBills.getPayButton().click();
    }

    @Then("the user gets {string} message")
    public void the_user_gets_message(String string) {
        PayBills payBills = new PayBills();
        Assert.assertEquals(string,payBills.getSuccesfulMessage());
    }

    @Then("the user should not get {string} message")
    public void the_user_should_not_get_message(String string) {
        PayBills payBills = new PayBills();
        System.out.println(payBills.getSuccesfulMessage());
        Assert.assertNotEquals(string,payBills.getSuccesfulMessage());

    }

    @Then("the user should get {string} alert")
    public void the_user_should_get_alert(String string) {
        PayBills payBills = new PayBills();
        String actualErrorMessage = payBills.getDateInput().getAttribute("validationMessage");
        Assert.assertEquals(string,actualErrorMessage);
    }
}
