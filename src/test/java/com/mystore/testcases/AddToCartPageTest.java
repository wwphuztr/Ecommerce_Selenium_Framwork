package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartPageTest extends BaseClass {
    IndexPage index;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;

    @BeforeMethod
    public void setup() {
        lauchApp();
    }

    @Test
    public void addToCartTest() throws InterruptedException {
        index = new IndexPage();
        addToCartPage = new AddToCartPage();
        searchResultPage = index.searchProduct("t-shirt");
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
