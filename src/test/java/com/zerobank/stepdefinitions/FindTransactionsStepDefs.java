package com.zerobank.stepdefinitions;

import com.zerobank.pages.FindTransactions;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FindTransactionsStepDefs {
    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        FindTransactions findTransactions = new FindTransactions();
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        findTransactions.getFindTransactionsTab().click();
        wait.withTimeout(Duration.ofSeconds(2));
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String string, String string2) {
        FindTransactions findTransactions = new FindTransactions();
        findTransactions.getInputDateFrom().sendKeys(string+Keys.TAB);
        findTransactions.getInputDateTo().sendKeys(string2+Keys.TAB);
    }
    @When("the user enters a second search date range from {string} to {string}")
    public void the_user_enters_a_second_search_date_range_from_to(String string, String string2) {
        FindTransactions findTransactions = new FindTransactions();
        Driver.get().navigate().refresh();
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        findTransactions.getFindTransactionsTab().click();
        wait.withTimeout(Duration.ofSeconds(2));
        findTransactions.getInputDateFrom().sendKeys(string+Keys.TAB);
        findTransactions.getInputDateTo().sendKeys(string2+Keys.TAB);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String string, String string2) throws ParseException, InterruptedException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
        Date firstDate=sdf.parse(string);
        Date lastDate=sdf.parse(string2);

        FindTransactions findTransactions = new FindTransactions();
        List<String> stringList=findTransactions.textsOfSelectTypeResults("date");

        List<Date> dateList = new ArrayList<>();

        for(int i=0; i<stringList.size(); i++){
            dateList.add(sdf.parse(stringList.get(i)));
        }

        for(int i=0; i<dateList.size(); i++){
            Assert.assertTrue("results table should only show dates between: ",
                    (dateList.get(i).equals(firstDate) || dateList.get(i).after(firstDate)) &&
                            (dateList.get(i).equals(lastDate) || dateList.get(i).before(lastDate)));
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
        FindTransactions findTransactions = new FindTransactions();
        List<String> stringList=findTransactions.textsOfSelectTypeResults("date");

        List<Date> dateList = new ArrayList<>();

        for(int i=0; i<stringList.size(); i++){
            dateList.add(sdf.parse(stringList.get(i)));
        }
        for(int i=0; i<dateList.size()-1; i++) {
            Assert.assertTrue("results should be sorted by most recent date: ", (dateList.get(i).compareTo(dateList.get(i + 1)) == 0) || (dateList.get(i).compareTo(dateList.get(i + 1)) > 0));
        }
            /*
        boolean result=false;
        for(int i=0; i<dateList.size()-1; i++) {
            if((dateList.get(i).compareTo(dateList.get(i+1))==0) || (dateList.get(i).compareTo(dateList.get(i+1))>0)){
                result=true;
            }else{
                result=false;
                break;
            }
        }
        System.out.println("loop result: " + result);
        Assert.assertTrue("results should be sorted by most recent date: ",result);

         */
        /*
        for(int i=0; i<dateList.size()-1; i++) {
            System.out.println("date first: " + dateList.get(i) + "date second: " + dateList.get(i+1));
            System.out.println(dateList.get(i).after(dateList.get(i+1)));
            Assert.assertTrue("results should be sorted by most recent date: ",(dateList.get(i).after(dateList.get(i+1))));
        }
         */

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
        Date notContain=sdf.parse(string);
        FindTransactions findTransactions = new FindTransactions();
        List<String> stringList=findTransactions.textsOfSelectTypeResults("date");

        List<Date> dateList = new ArrayList<>();

        for(int i=0; i<stringList.size(); i++){
            dateList.add(sdf.parse(stringList.get(i)));
        }
        for(int i=0; i<dateList.size(); i++){
            System.out.println("before notContain: " + (notContain.before(dateList.get(i))) + "&& after notContain: "+(notContain.after(dateList.get(i))));
            Assert.assertFalse("the results table should only not contain transactions dated: ",(dateList.get(i).equals(notContain)));
            }
        //(dateList.get(i).before(notContain) && dateList.get(i).after(notContain)));
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        FindTransactions findTransactions = new FindTransactions();
        wait.withTimeout(Duration.ofSeconds(1));
        findTransactions.getInputDescription().clear();
        wait.withTimeout(Duration.ofSeconds(1));
        findTransactions.getInputDescription().sendKeys(string + Keys.ENTER);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        FindTransactions findTransactions = new FindTransactions();
        String path="//div[@id='filtered_transactions_for_account']//td[2]";
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(path)));
        List<String> attributes=findTransactions.getAttributeFindResults();
        System.out.println(attributes);
        System.out.println(string);
        for(int i=0; i<attributes.size(); i++) {
            Assert.assertTrue(attributes.get(i).contains(string));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        FindTransactions findTransactions = new FindTransactions();
        String path="//div[@id='filtered_transactions_for_account']//td[2]";
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(path)));
        List<String> attributes=findTransactions.getAttributeFindResults();

        for(int i=0; i<attributes.size(); i++){
            Assert.assertFalse(attributes.get(i).contains(string));
        }
    }

    @And("clicks search")
    public void clicks_search() throws InterruptedException {
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        String path="//button[@class='btn btn-primary']";
        FindTransactions findTransactions = new FindTransactions();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        findTransactions.getButtonFind().click();
        Thread.sleep(2000);
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        FindTransactions findTransactions = new FindTransactions();
        wait.withTimeout(Duration.ofSeconds(2));
        System.out.println("at least one result under deposit" + findTransactions.attributesOfSelectTypeResults("deposit").size());
        //Assert.assertTrue(findTransactions.getDepositResults().size() >=1);
        //Assert.assertTrue(findTransactions.selectTypeResults("deposit").size() >=1);
        Assert.assertTrue(findTransactions.attributesOfSelectTypeResults("deposit").size() >=1);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        FindTransactions findTransactions = new FindTransactions();
        wait.withTimeout(Duration.ofSeconds(2));
        System.out.println("at least one result under withdrawal" + findTransactions.attributesOfSelectTypeResults("withdrawal").size());
        //Assert.assertTrue(findTransactions.getWithrawalResults().size() >=1);
        //Assert.assertTrue(findTransactions.selectTypeResults("withdrawal").size() >=1);
        Assert.assertTrue(findTransactions.attributesOfSelectTypeResults("withdrawal").size() >=1);
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        FindTransactions findTransactions = new FindTransactions();
        wait.withTimeout(Duration.ofSeconds(1));
        findTransactions.selectFromType(string);
        wait.withTimeout(Duration.ofSeconds(2));
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        FindTransactions findTransactions = new FindTransactions();
        wait.withTimeout(Duration.ofSeconds(2));
        List<String> list=findTransactions.attributesOfSelectTypeResults("withdrawal");
        System.out.println("no result under withdrawal"+list.size());
        for(int i=0; i<list.size(); i++) {
            Assert.assertTrue(list.get(i).isEmpty());
        }
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        FindTransactions findTransactions = new FindTransactions();
        wait.withTimeout(Duration.ofSeconds(2));
        List<String> list=findTransactions.attributesOfSelectTypeResults("deposit");
        System.out.println("no result under Deposit" + list.size());
        for(int i=0; i<list.size(); i++) {
            Assert.assertTrue(list.get(i).isEmpty());
        }
    }
}
