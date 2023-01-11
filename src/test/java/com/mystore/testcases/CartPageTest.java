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

import java.text.DecimalFormat;

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
        //searchResultPage = indexPage.searchProduct("pant");
        searchResultPage = indexPage.searchProduct("lip");
        addToCartPage = searchResultPage.clickOnProduct();
        int quantity = 20;
        int quantityExpected = quantity;
        // because we have one available quantity on each product we choose
        quantity = quantity - 1;
        addToCartPage.enterQuantity(quantity);
        addToCartPage.clickOnAddToCart();
        boolean result = addToCartPage.validateAddToCart();
        // Handle whether the quantity is equal to actual quantity after adding the product
        int actualQuantity = addToCartPage.checkActualQuantityAfterClick();
        //check whether the actual quantity and expected quantity is equal or not
        Assert.assertEquals(actualQuantity, quantityExpected, "The actual quantity is not equal with expected quantity");
        cartPage = addToCartPage.clickonCart();
        //get unit, shipping and total price
        Double unitPrice = cartPage.getUnitPrice();
        Double shippingPrice = cartPage.getShippingPrice();
        Double totalPrice = cartPage.getTotalPrice();
        Double totalPriceExpected = (unitPrice*(quantityExpected)) + shippingPrice;
        totalPriceExpected =  Double.parseDouble(new DecimalFormat("##.##").format(totalPriceExpected));

        Assert.assertEquals(totalPriceExpected, totalPrice);
        Thread.sleep(30000);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
