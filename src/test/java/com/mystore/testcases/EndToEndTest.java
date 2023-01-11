package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseClass {
    IndexPage indexPage;
    AddToCartPage addToCartPage;
    SearchResultPage searchResultPage;
    CartPage cartPage;
    CheckOutPage checkOutPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        lauchApp();
    }

    @Test
    public void endToEndTest() throws InterruptedException {
        indexPage = new IndexPage();
        addToCartPage = new AddToCartPage();
        searchResultPage = indexPage.searchProduct("lip");
        addToCartPage = searchResultPage.clickOnProduct();
        int quantity = 2;
        int quantityExpected = quantity;
        // because we have one available quantity on each product we choose
        quantity = quantity - 1;

        addToCartPage.enterQuantity(quantity);
        addToCartPage.clickOnAddToCart();
        cartPage = addToCartPage.clickonCart();
        checkOutPage = cartPage.clickonCheckout();
        //check the customer is a guest or logged in
        if (checkOutPage.CheckisAGuestOrLogged()) {

        }
        else  {
            checkOutPage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
        }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
