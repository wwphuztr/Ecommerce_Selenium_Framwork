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
        PageFactory.initElements(getDriver(), this);

    }

    public void clickIAmNotRobot() throws InterruptedException {
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("*//iframe[@title='reCAPTCHA']")));
        System.out.println("Test is display for iAmNotRobot");
        System.out.println("--------------------------------");
        action.isDisplayed(getDriver(), iAmNotRobot);
        System.out.println("--------------------------------");

        action.click(getDriver(), iAmNotRobot);
        System.out.println("--------------------------------");

        getDriver().switchTo().defaultContent();
        if(action.isDisplayed(getDriver(), capChaImage)) {
            Thread.sleep(20000);
        }
    }

    public void clickNext() {
        action.visibilityOf(getDriver(), nextButton, 10);
        action.click(getDriver(), nextButton);
    }
    public boolean CheckisAGuestOrLogged() {
        String title = getDriver().getCurrentUrl();
        return title.contains("sign-in");
    }
}
