package com.mystore.testcases;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartPageTest extends BaseClass {
    IndexPage index;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    Action action;

    @BeforeMethod
    public void setup() {
        lauchApp();
    }

    @Test
    public void addToCartTest() throws InterruptedException {
        index = new IndexPage();
        addToCartPage = new AddToCartPage();
        searchResultPage = index.searchProduct("pant");
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity(1);
        addToCartPage.clickOnAddToCart();
        boolean result = addToCartPage.validateAddToCart();
        //boolean result = addToCartPage.validateAddToCart2();
        Assert.assertTrue(result);
        Thread.sleep(3000);
    }

    @AfterMethod
    public void teardown() {
        getDriver().quit();
    }
}
