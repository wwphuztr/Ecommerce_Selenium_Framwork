package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.CartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTest extends BaseClass {
    IndexPage indexPage;
    AddToCartPage addToCartPage;
    SearchResultPage searchResultPage;
    CartPage cartPage;

    @BeforeMethod
    public void setup() {
        lauchApp();
    }

    @Test
    public void verifyTotalPrice() throws InterruptedException {
        indexPage = new IndexPage();
        addToCartPage = new AddToCartPage();
        searchResultPage = indexPage.searchProduct("pant");
        addToCartPage = searchResultPage.clickOnProduct();
        int quantity = 1;
        addToCartPage.enterQuantity(quantity);
        addToCartPage.clickOnAddToCart();
        boolean result = addToCartPage.validateAddToCart();
        addToCartPage.clickonCart();
        Assert.assertTrue(result);
        Thread.sleep(30000);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
