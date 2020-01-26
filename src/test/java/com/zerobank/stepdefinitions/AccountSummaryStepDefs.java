package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {
    @Given("the user is in the Account Summary Page")
    public void the_user_is_in_the_Account_Summary_Page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    }

    @Then("user should see following account types")
    public void user_should_see_following_account_types(List<String> account_types) throws InterruptedException {
        Thread.sleep(5000);
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Assert.assertEquals(account_types,
                accountSummaryPage.getStringAccountTypes(accountSummaryPage.getAccountTypes()));
    }

    @Then("user should see following columns")
    public void user_should_see_following_columns(List<String> columns) throws InterruptedException {
        Thread.sleep(5000);
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Assert.assertEquals(columns,
                accountSummaryPage.getStringCreditAccountsColumns(accountSummaryPage.getCreditAccountsColumns()));
    }

}
