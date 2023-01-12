package com.mystore.base;

import com.mystore.actiondriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static Properties prop;
    public static WebDriver driver;
    public static Action action;

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
            driver = new ChromeDriver();
        } else if (browserName.contains("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browserName.contains("IE")) {
            driver = new InternetExplorerDriver();
        }

        Action.impliciWait(driver, 10);
        Action.pageLoadTimeOut(driver, 50);
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1440, 900));
        driver.get(prop.getProperty("url"));
    }
}
