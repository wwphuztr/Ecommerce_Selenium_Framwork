package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends BaseClass {
    Action action = new Action();

    public CheckOutPage() {
        PageFactory.initElements(driver, this);

    }
    public boolean CheckisAGuestOrLogged() {
        String title = driver.getCurrentUrl();
        return title.contains("sign-in");
    }
}
