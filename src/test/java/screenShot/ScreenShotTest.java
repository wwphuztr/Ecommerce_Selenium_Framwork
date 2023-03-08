package screenShot;

import com.aventstack.extentreports.utils.FileUtil;
import com.mystore.utility.TakeScreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShotTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();

        //System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @Test
    public void testcase1() throws IOException {
        driver.findElement(By.xpath("//input[@title='Tìm kiếm']")).sendKeys("testing");
        //TakeScreenShot.screenShot(driver, "file2");
        Assert.assertTrue(false);
    }

    @Test
    public void testcase2() throws IOException {
        //TakeScreenShot.screenShot(driver, "file3");
        Assert.assertTrue(false);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.FAILURE == result.getStatus()) {
            TakeScreenShot.screenShot(driver,   result.getName());
        }
        driver.close();
    }
}