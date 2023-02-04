package com.mystore.base;

import com.mystore.actiondriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static Properties prop;
    //public static WebDriver driver; ==> https://www.linkedin.com/pulse/selenium-parallel-testing-using-java-threadlocal-testng-shargo/
    public static Action action;

    //Declare ThreadLocal Driver
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        //Get driver from threadLocalMap
        return driver.get();
    }

    @BeforeTest
    public void loadConfig() {
        try {
            prop = new Properties();
            System.out.println("super constructor invoked");
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "\\Configuration\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lauchApp() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--window-size=1400,600");

        WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browser");

        if (browserName.contains("Chrome")) {
            //driver = new ChromeDriver();
            //Set Browser to ThreadLocalMap
            driver.set(new ChromeDriver());
        } else if (browserName.contains("FireFox")) {
            //driver = new FirefoxDriver();
            driver.set(new FirefoxDriver());
        } else if (browserName.contains("IE")) {
            //driver = new InternetExplorerDriver();
            driver.set(new InternetExplorerDriver());
        }

        Action.impliciWait(getDriver(), 10);
        Action.pageLoadTimeOut(getDriver(), 50);
        getDriver().manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1440, 900));
        getDriver().get(prop.getProperty("url"));
    }
}
