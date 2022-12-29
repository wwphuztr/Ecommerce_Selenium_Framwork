package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        lauchApp();
    }

    @Test
    public void loginTest() {
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
        String actualURL = homePage.getCurrentURL();
        String expectedURL = "https://www.lifepharmacy.co.nz/";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
