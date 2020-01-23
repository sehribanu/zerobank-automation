package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AccountSummaryStepDefs {
    @Then("Account Summary page should be displayed")
    public void account_Summary_page_should_be_displayed() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Assert.assertEquals(accountSummaryPage.getExpectedAccountSummaryTitle(), accountSummaryPage.getActualAccountSummaryTitle());
    }

}
