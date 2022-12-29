package com.mystore.testcases;

import com.mystore.base.BaseClass;
import org.testng.annotations.*;

public class IndexPageTest  {
    @BeforeTest
    public void launchBrowser() {
        System.out.printf("launchBrowser");
    }

    @BeforeMethod
    public void verifyHomepageTitle() {
        System.out.printf("verify HomePage Title");
    }

    @Test(priority = 0)
    public void register(){
        System.out.printf("register");
    }

    @Test(priority = 1)
    public void support() {
        System.out.printf("support");
    }

    @AfterMethod
    public void goBackToHomePage() {
        System.out.printf("go back to Home Page");
    }

    @AfterTest
    public void terminateBrowser() {
        System.out.printf("terminateBrowser");
    }
}
