package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseClass {
    Action action;

    @FindBy(xpath = "//span[@class='title-mobile']")
    WebElement unitPrice;

    @FindBy(xpath = "//div[@class='txt-value pl-2 cartShippingAndHandling']")
    WebElement shippingPrice;

    @FindBy(xpath = "//div[@class='txt-value pl-2 cartTotal']")
    WebElement totalPrice;

    CartPage() {
        PageFactory.initElements(driver, this);
    }

//    public double getUnitPrice() {
//        action.fluentwait(driver, unitPrice, 10);
//
//    }
}
