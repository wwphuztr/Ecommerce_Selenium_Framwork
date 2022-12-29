package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BaseClass {
    Action action = new Action();

    @FindBy(xpath = "//div[contains(text(),'0 results found')]")
    private WebElement productResult;

    @FindBy(xpath = "//img[contains(@alt,'Boody Mens Crew Neck TShirt M White 1ea')]")
    private WebElement firstProduct;

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isProductAvailable() {
        return action.isDisplayed(driver, productResult);
    }

    public AddToCartPage clickOnProduct() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@alt,'Boody Mens Crew Neck TShirt M White 1ea')]"))).click();
        //action.click(driver, firstProduct);
        Thread.sleep(10000);
        return new AddToCartPage();
    }
}
