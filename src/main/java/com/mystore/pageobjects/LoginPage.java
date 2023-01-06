package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    Action action = new Action();

    @FindBy(xpath = "//img[@src='\\Static\\assets\\images\\header\\sign-in.svg']")
    WebElement signIn_Icon;

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@id='loginButton']")
    WebElement signInBtn;

    @FindBy(xpath = "//a[normalize-space()='Create One Now']")
    WebElement create_a_new_one;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage Login(String user, String pass) {
        action.type(username, user);
        action.type(password, pass);
        action.click(driver, signInBtn);
        return new HomePage();
    }
}
