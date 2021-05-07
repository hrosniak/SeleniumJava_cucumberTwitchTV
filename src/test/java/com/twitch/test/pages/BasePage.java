package com.twitch.test.pages;

import com.twitch.test.Drivers;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;



public abstract class BasePage {
    public final RemoteWebDriver driver;

    public BasePage() {
        this.driver = Drivers.DRIVER;
        PageFactory.initElements(this.driver, this);
    }
}
