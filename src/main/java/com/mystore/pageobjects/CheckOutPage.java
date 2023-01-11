package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class CheckOutPage extends BaseClass {
    Action action = new Action();

    public boolean CheckisAGuestOrLogged() {
        String title = driver.getCurrentUrl();
        return title.contains("sign-in");
    }
}
