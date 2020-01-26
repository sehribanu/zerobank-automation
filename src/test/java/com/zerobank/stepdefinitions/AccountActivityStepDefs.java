package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
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
        AccountActivity accountActivity = new AccountActivity();
        accountActivity.navigateToAccountActivityPage();
        WebDriverWait wait = new WebDriverWait(Driver.get(),1);
    }

    @When("the user is in the Account Activity Page")
    public void the_user_is_in_the_Account_Activity_Page() {
        String expectedTitle = "Zero - Account Activity";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("the dropdown default option should be {string}")
    public void the_dropdown_default_option_should_be(String expectedDefaultOption) {
        expectedDefaultOption = "Savings";
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

}
