package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.jsoup.Connection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends BaseClass {
    @FindBy(xpath = "//h1[normalize-space()='Join Life Pharmacy']")
    WebElement form_Title;

    public AccountCreationPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean validate_Account_Create_Page() {
        return action.isDisplayed(driver, form_Title);
    }
}
