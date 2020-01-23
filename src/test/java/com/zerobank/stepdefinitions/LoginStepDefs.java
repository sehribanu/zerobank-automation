package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginPage;

    @Given("the user navigates to login page")
    public void the_user_navigates_to_login_page() {
        loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
    }
    @When("the user gives valid credentials to login")
    public void the_user_gives_valid_credentials_to_login() {
        loginPage.credentialsToLogin(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
        loginPage.clickToLogin();
    }
    @When("the user gives wrong credentials to login")
    public void the_user_gives_wrong_credentials_to_login() throws InterruptedException {
        Thread.sleep(4000);
        loginPage.credentialsToLogin(ConfigurationReader.get("wrongUsername"),ConfigurationReader.get("wrongPassword"));
        Thread.sleep(1000);
        loginPage.clickToLogin();
    }
    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertEquals(loginPage.getExpectedErrorMessage(),loginPage.getActualErrorMessage());
    }
    @When("the user does not give credentials to login")
    public void the_user_does_not_give_credentials_to_login() {
        loginPage.clickToLogin();
    }
}
