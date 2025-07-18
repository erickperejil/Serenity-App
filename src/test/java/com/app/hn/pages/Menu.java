package com.app.hn.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class Menu extends PageObject {
    @FindBy(xpath = "//android.view.View[@content-desc='home']")
    protected WebElement btn_home;

    @FindBy(xpath = "//android.view.View[@content-desc='transfers']")
    protected WebElement btn_transfer;

}
