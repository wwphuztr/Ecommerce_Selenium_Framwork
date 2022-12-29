package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    @FindBy(xpath = "//span[@class='siteHeader-actionIcon fas fa-heart']")
    WebElement myWishList;

    @FindBy(xpath = "//ul[@role='menu']//a[@title='Order History'][normalize-space()='Order History']")
    WebElement order_History;

    @FindBy(xpath = "//img[@src='\\Static\\assets\\images\\header\\sign-in.svg']")
    WebElement icon_Profile;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}
