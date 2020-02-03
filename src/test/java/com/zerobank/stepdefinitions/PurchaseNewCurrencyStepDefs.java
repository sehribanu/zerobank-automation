package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBills;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PurchaseNewCurrencyStepDefs {
    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() throws InterruptedException {
        PayBills payBills = new PayBills();
        payBills.getPurchaseForeignCurrencyTab().click();
        Thread.sleep(1000);
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        PayBills payBills = new PayBills();
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        List<String> list = payBills.getCurrencyText();
        wait.withTimeout(Duration.ofSeconds(1));

        for(int i=0; i<dataTable.size();i++) {
            Assert.assertTrue(list.contains(dataTable.get(i)));
        }
    }
    //@all
    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() throws InterruptedException {

        PayBills payBills = new PayBills();
        Thread.sleep(1000);
        payBills.getButtonCalculate().click();
        Thread.sleep(1000);
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() throws InterruptedException {
        PayBills payBills = new PayBills();
        Thread.sleep(1000);
        payBills.selectCurrency();
        Thread.sleep(1000);
        payBills.getButtonCalculate().click();
        Thread.sleep(1000);

    }
    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String string) {
        Alert alert = Driver.get().switchTo().alert();
        String actString=alert.getText();
        Assert.assertEquals(string,actString);
    }

}
