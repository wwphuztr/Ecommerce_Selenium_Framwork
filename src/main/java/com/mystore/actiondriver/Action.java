package com.mystore.actiondriver;

import com.mystore.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Action extends BaseClass {
    public static void impliciWait(WebDriver driver, int timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
        driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
    }

    public void click(WebDriver webDriver, WebElement webElement) {
        webElement.click();
    }

    public void enter(WebDriver webDriver, WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    public boolean findElement(WebDriver driver, WebElement element) {
        boolean flag = false;

        try {
            element.isDisplayed();
            flag = true;
        } catch (Exception e) {
            System.out.println("(findElement) - Can not locate the element");
            flag = false;
        } finally {
            if (flag) {
                System.out.println("(findElement) - The element found");
            }
            else {
                System.out.println("(findElement) - The element not found");
            }
        }

        return flag;
    }

    public boolean isDisplayed(WebDriver driver, WebElement element) {
        boolean flag = false;
        flag = findElement(driver, element);

        if(flag) {
            flag = element.isDisplayed();
            if (flag) {
                System.out.println("(isDisplayed) - The element is displayed");
            }
            else {
                System.out.println("(isDisplayed) - The element is not displayed");
            }
        }
        else {
            System.out.println("(isDisplayed) - Not displayed");
        }

        return flag;
    }

    public boolean type(WebElement element, String text) {
        boolean flag = false;
        try {
            flag = element.isDisplayed();
            element.clear();
            element.sendKeys(text);
            flag = true;
        }
        catch (Exception e) {
            System.out.println("(Type) Location not found");
            flag = false;
        }
        finally {
            if (flag) {
                System.out.println("(Type) Successfully entered value");
            }
            else {
                System.out.println("(Type) Unable to enter value");
            }
        }
        return flag;
    }

    public boolean visibilityOf(WebDriver driver, WebElement element, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        boolean result = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        return result;
    }

    public void fluentwait(WebDriver driver, WebElement element, int timeOut) {
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<WebDriver>((WebDriver) driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (Exception e) {

        }
    }
}
