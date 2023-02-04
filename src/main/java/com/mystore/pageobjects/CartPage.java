package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseClass {
    Action action = new Action();

    @FindBy(xpath = "//div[@class='shoppingCartItem-content']//div[@class='cell-price']")
    WebElement unitPrice;

    @FindBy(xpath = "//div[@class='txt-value pl-2 cartShippingAndHandling']")
    WebElement shippingPrice;

    @FindBy(xpath = "//div[@class='txt-value pl-2 cartTotal']")
    WebElement totalPrice;

    @FindBy(xpath = "//button[@type='submit'][normalize-space()='Checkout']")
    WebElement checkoutButton;

    CartPage() {
        PageFactory.initElements(driver, this);
    }


    public CheckOutPage clickonCheckout() {
        action.visibilityOf(driver, checkoutButton, 10);
        System.out.println("Test CHECK OUT button");
        action.isDisplayed(driver, checkoutButton);
        action.click(driver, checkoutButton);
        return new CheckOutPage();
    }
    public double getUnitPrice() {
        action.fluentwait(driver, unitPrice, 10);
        String uPrice1 = unitPrice.getText();
        String uPrice2 = uPrice1.replace("$", "");
        double finalUnitPrice = Double.parseDouble(uPrice2);
        System.out.println("(CartPage) UnitPrice: " + finalUnitPrice);
        return finalUnitPrice;
    }

    public double getShippingPrice() {
        action.fluentwait(driver, shippingPrice, 10);
        String sPrice1 = shippingPrice.getText();
        String sPrice2 = sPrice1.replace("$", "");
        double finalShippingPrice = Double.parseDouble(sPrice2);
        System.out.println("(CartPage) ShippingPrice: " + finalShippingPrice);
        return finalShippingPrice;
    }

    public double getTotalPrice() {
        action.fluentwait(driver, totalPrice, 10);
        String tPrice1 = totalPrice.getText();
        String tPrice2 = tPrice1.replace("$", "");
        double totalPrice = Double.parseDouble(tPrice2);
        System.out.println("(CartPage) TotalPrice: " + totalPrice);
        return totalPrice;
    }
}
