package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityStepDefs {

    @Given("the user navigates to Account Activity Page")
    public void the_user_navigates_to_Account_Activity_Page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.navigateToAccountActivityPage();
    }

    @When("the user is in the Account Activity Page")
    public void the_user_is_in_the_Account_Activity_Page() {
        String expectedTitle = "Zero - Account Activity";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("the dropdown default option should be {string}")
    public void the_dropdown_default_option_should_be(String expectedDefaultOption) {
        //expectedDefaultOption = "Savings";
        AccountActivity accountActivity = new AccountActivity();
        String actualDefaultOption = accountActivity.getActualDefaultOption();
        Assert.assertEquals(expectedDefaultOption,actualDefaultOption);
    }

    @Then("user should see following dropdown options")
    public void user_should_see_following_dropdown_options(List<String> expectedDropdownOptions) {
        AccountActivity accountActivity = new AccountActivity();
        List<String> actualDropdownOptions = accountActivity.getActualOptionsListString();
        Assert.assertEquals(expectedDropdownOptions,actualDropdownOptions);
    }

    @Then("user should see following column names in transactions")
    public void user_should_see_following_column_names_in_transactions(List<String> expectedColumnTitles) {
        AccountActivity accountActivity = new AccountActivity();
        Assert.assertEquals(expectedColumnTitles,accountActivity.getActualColumnTitles());
    }
    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.clickSavingsLink();
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        String expectedTitle = "Zero - Account Activity";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("Account drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {
        AccountActivity accountActivity = new AccountActivity();
        String expectedDefaultOption = "Savings";
        String actualDefaultOption = accountActivity.getActualDefaultOption();
        Assert.assertEquals(expectedDefaultOption,actualDefaultOption);
    }

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.clickBrokerageLink();
    }

    @Then("Account drop down should have Brokerage selected")
    public void account_drop_down_should_have_Brokerage_selected() {
        AccountActivity accountActivity = new AccountActivity();
        Assert.assertTrue(accountActivity.getBrokerageOption().isSelected());
    }

    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.clickCheckingLink();
    }

    @Then("Account drop down should have Checking selected")
    public void account_drop_down_should_have_Checking_selected() {
        AccountActivity accountActivity = new AccountActivity();
        Assert.assertTrue(accountActivity.getCheckingOption().isSelected());
    }

    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.clickCreditCardLink();
    }

    @Then("Account drop down should have Credit Card selected")
    public void account_drop_down_should_have_Credit_Card_selected() {
        AccountActivity accountActivity = new AccountActivity();
        Assert.assertTrue(accountActivity.getCreditcardOption().isSelected());
    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.clickLoanLink();
        the_user_is_in_the_Account_Activity_Page();

    }

    @Then("Account drop down should have Loan selected")
    public void account_drop_down_should_have_Loan_selected() {
        AccountActivity accountActivity = new AccountActivity();
        Assert.assertTrue(accountActivity.getLoanOption().isSelected());
    }

}
