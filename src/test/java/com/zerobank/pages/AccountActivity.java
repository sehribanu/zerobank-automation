package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends BasePage {

    public AccountActivity(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(id = "aa_accountId")
    private WebElement dropDown;

    @FindBy(xpath = "//table[@class='table table-condensed table-hover']/thead/tr/th")
    private List<WebElement> columnTitles;

    WebDriverWait wait = new WebDriverWait(Driver.get(),10);

    public List<String> getActualOptionsListString(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_accountId")));
        Select select = new Select(dropDown);

        List<WebElement> actualOptions = select.getOptions();
        List<String> textActualOptions = new ArrayList<>();

        for(WebElement k: actualOptions){
            textActualOptions.add(k.getText());
        }
        return textActualOptions;
    }
    public String getActualDefaultOption(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_accountId")));
        Select select = new Select(dropDown);
        String actualDefaultOption = select.getFirstSelectedOption().getText();
        return actualDefaultOption;
    }
    public List<String> getActualColumnTitles(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='table table-condensed table-hover']/thead/tr/th")));
        List<String> actualColumnTitles = new ArrayList<>();
        for(WebElement k : columnTitles){
            actualColumnTitles.add(k.getText());
        }
        return actualColumnTitles;
    }


}
