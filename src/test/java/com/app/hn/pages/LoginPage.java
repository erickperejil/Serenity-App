package com.app.hn.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageObject {
    @FindBy(xpath = "//android.widget.Button[@content-desc='Sign in']")
    protected WebElement btn_signIn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='undefined.label, *, Forgot?']/android.widget.EditText")
    protected WebElement txt_username;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='password']")
    protected WebElement txt_password;

    @FindBy(xpath = "(//android.widget.TextView[@text='Log in'])[2]")
    protected WebElement btn_logIn;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2']")
    protected WebElement btn_cancelPopUp;



}
