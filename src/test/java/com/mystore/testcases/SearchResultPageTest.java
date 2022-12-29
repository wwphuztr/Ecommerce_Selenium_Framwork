package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseClass {
    private IndexPage index;
    private SearchResultPage searchResultPage;

    //@Parameters("browser")
    @BeforeMethod
    public void setup() {
        lauchApp();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void productAvailability() throws Throwable {
        index = new IndexPage();
        searchResultPage = index.searchProduct("T-shirt");
        boolean result = searchResultPage.isProductAvailable();
        Assert.assertFalse(result);
    }
}
