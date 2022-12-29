package com.mystore;

import com.opencsv.bean.CsvToBeanBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StaticProvider {
    WebDriver driver;
    String driverPath = "D:\\chromedriver.exe";

    private <T> List<T> getDataAsObject(String pathtoFile, Class<T> type) {
        List<T> tList = new ArrayList<>();

        try (Reader reader = new FileReader(pathtoFile)) {
            tList = new CsvToBeanBuilder<T>(reader)
                    .withType(type)
                    .build().parse();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return tList;
    }

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "LoginData")
    public void loginTest(UserProfile userProfile) throws InterruptedException {
        driver.get("https://admin-demo.nopcommerce.com/login");

        WebElement txtEmail = driver.findElement(By.id("Email"));
        txtEmail.clear();
        txtEmail.sendKeys(userProfile.getUser());

        WebElement txtPassword = driver.findElement(By.id("Password"));
        txtPassword.clear();
        txtPassword.sendKeys(userProfile.getPwd());

        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

        String exp_title = "Dashboard / nopCommerce administration";
        String act_title = driver.getTitle();

        if(userProfile.getExp().equals("Valid")) {
            if(exp_title.equals(act_title)) {
                Assert.assertTrue(true);
            }
            else {
                Assert.assertTrue(false);
            }
        }
        else if(userProfile.getExp().equals("Invalid")) {
            if (exp_title.equals(act_title)) {
                driver.findElement(By.linkText("Logout")).click();
                Assert.assertTrue(false);
            }
            else {
                Assert.assertTrue(true);
            }
        }
    }

    @DataProvider(name="LoginData")
    public Iterator<UserProfile> createData() {
        List<UserProfile> data = getDataAsObject("src/main/resources/test.csv", UserProfile.class);
        return data.iterator();
    }

    @AfterClass
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
