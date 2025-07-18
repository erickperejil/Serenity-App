package com.app.hn.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class TranfersPage extends Menu {
    @FindBy(xpath = " //android.widget.Button[@content-desc='btn.framework.common.components.menu.transfer_ownAccounts']")
    protected WebElement btn_ownAccounts;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='source']")
    protected WebElement btn_sourceAccount;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc='viw.productInfo, viw.productCard.leftComponent, viw.productCard.rightComponent'])[1]")
    protected WebElement btn_sourceAccountOption;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='target']")
    protected WebElement btn_targetAccount;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc='viw.productInfo, viw.productCard.leftComponent, viw.productCard.rightComponent'])")
    protected WebElement btn_targetAccountOption;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='txt.amountLabel, *, txt.currentValue']")
    protected WebElement btn_currentValue;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='btn.number1']/android.view.ViewGroup")
    protected WebElement btn_number1;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='btn.number0']/android.view.ViewGroup")
    protected WebElement btn_number0;

    @FindBy(xpath = "//android.widget.Button[@content-desc='btn.framework.common.apply']")
    protected WebElement btn_applyCurrency;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='inp.concept']")
    protected WebElement txt_concept;

    @FindBy(xpath = "(//android.widget.Button[@content-desc='btn.undefined'])[2]")
    protected WebElement btn_continue;

    @FindBy(xpath = "(//android.widget.Button[@content-desc='btn.undefined'])[2]")
    protected WebElement btn_confirmTransfer;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='txt.navbar.primaryText']")
    protected WebElement lbl_resultado;






}
