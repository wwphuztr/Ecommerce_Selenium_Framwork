package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends BaseClass {
    Action action = new Action();

    @FindBy(xpath = "//button[normalize-space()='Next']")
    WebElement nextButton;

    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]")
    WebElement iAmNotRobot;

    @FindBy(xpath = "//*[@id=\"rc-imageselect\"]")
    WebElement capChaImage;

    public CheckOutPage() {
        PageFactory.initElements(driver, this);

    }

    public void clickIAmNotRobot() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.xpath("*//iframe[@title='reCAPTCHA']")));
        action.click(driver, iAmNotRobot);
        driver.switchTo().defaultContent();
        if(action.isDisplayed(driver, capChaImage)) {
            Thread.sleep(20000);
        }
    }

    public void clickNext() {
        action.visibilityOf(driver, nextButton, 10);
        action.click(driver, nextButton);
    }
    public boolean CheckisAGuestOrLogged() {
        String title = driver.getCurrentUrl();
        return title.contains("sign-in");
    }
}
