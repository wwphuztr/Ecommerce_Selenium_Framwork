package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage extends BaseClass {
    Action action = new Action();

    @FindBy(xpath = "//span[@class='fas fa-plus']")
    WebElement plusButton;

    @FindBy(xpath = "//button[normalize-space()='Add To Cart']")
    WebElement addToCart_Button;

    @FindBy(xpath = "//div[@class='added-text']")
    WebElement addedToCartText;

    @FindBy(xpath = "//div[@class='notifications-cartCount']")
    WebElement cart;

    @FindBy(xpath = "//div[@class='quantityInput mt-4']//input[@value='1']")
    WebElement actualQuantity;

    public AddToCartPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public int checkActualQuantityAfterClick() {
        int quantity;
        if (actualQuantity.getAttribute("data-prev") == null) {
            quantity = 1;
        } else {
            String quantityString;
            quantityString = actualQuantity.getAttribute("data-prev");
            quantity = Integer.parseInt(quantityString);
        }
        return quantity;
    }

    public void enterQuantity(int q) {
        for (int i=1; i<=q; i++) {
            try {
                action.click(getDriver(), plusButton);
            }
            catch (Exception e) {
                System.out.println("(AddToCart) Out of stock !!");
            }
        }
    }

    public void clickOnAddToCart() {
        action.click(getDriver(), addToCart_Button);
    }

    public CartPage clickonCart() {
        action.click(getDriver(), cart);
        return new CartPage();
    }

    public boolean validateAddToCart() {
        return action.visibilityOf(getDriver(), addedToCartText, 10);
    }

    public boolean validateAddToCart2() {
        action.fluentwait(getDriver(), addedToCartText, 10);
        return action.isDisplayed(getDriver(), addedToCartText);
    }
}
