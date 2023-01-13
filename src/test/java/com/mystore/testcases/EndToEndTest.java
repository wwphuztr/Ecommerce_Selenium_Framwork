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
    LoginPage loginPage = new LoginPage();
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        lauchApp();
    }

    @Test
    public void endToEndTest() throws InterruptedException, InstantiationException, IllegalAccessException {
        indexPage = new IndexPage();
        addToCartPage = new AddToCartPage();
        searchResultPage = indexPage.searchProduct("dress");
        addToCartPage = searchResultPage.clickOnProduct();
        int quantity = 2;
        int quantityExpected = quantity;
        // because we have one available quantity on each product we choose
        quantity = quantity - 1;

        addToCartPage.enterQuantity(quantity);
        addToCartPage.clickOnAddToCart();
        boolean result = addToCartPage.validateAddToCart();
        cartPage = addToCartPage.clickonCart();
        checkOutPage = cartPage.clickonCheckout();
        //check the customer is a guest or logged in
        Thread.sleep(20000);
        checkOutPage = (CheckOutPage) loginPage.Login(prop.getProperty("username"), prop.getProperty("password"), CheckOutPage.class);

//        if (checkOutPage.CheckisAGuestOrLogged()) {
//            System.out.println("Logged");
//        }
//        else  {
//            System.out.println("Guest");
//            checkOutPage = (CheckOutPage) loginPage.Login(prop.getProperty("username"), prop.getProperty("password"), CheckOutPage.class);
//        }

        Thread.sleep(30000);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
