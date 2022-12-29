package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {
    Action action = new Action();

    @FindBy(xpath = "//img[@src='\\Static\\assets\\images\\header\\sign-in.svg']")
    WebElement signInBtn;

    @FindBy(xpath = "//img[@class='img-fluid siteHeader-siteLogo d-lg-none']")
    WebElement myStoreLogo;

    @FindBy(xpath = "//input[@class='searchBar-input']")
    WebElement searchProductBox;

    // xpath chỗ này có sự biến đổi, result có thể là một con số bất kỳ nào đó
    @FindBy(xpath = "//a[contains(normalize-space(), 'result')]")
    WebElement resultButton;



    @FindBy(xpath = "//div[@class='modal-header']//span[@class='icon-close']")
    WebElement x_button;

    @FindBy(xpath = "//input[@id='q']")
    WebElement search_panel;

    public IndexPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickOnSignIn() {
        action.click(driver, x_button);
        action.click(driver, signInBtn);
        return new LoginPage();
    }

    public boolean validateLogo() {
        return action.isDisplayed(driver, myStoreLogo);
    }

    public String getTitle() {
            String myTitle = driver.getTitle();
            return myTitle;
    }

    public SearchResultPage searchProduct(String productName) {
        action.click(driver, x_button);
        action.click(driver, search_panel);
        action.type(searchProductBox, productName);
        //action.click(driver, resultButton);
        action.enter(driver, searchProductBox);
        Action.impliciWait(driver, 6);

        return new SearchResultPage();
    }
}
