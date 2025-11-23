package com.lukasz.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary pull-xs-right']")
    private WebElement loginButton;

    @FindBy(xpath = "//h1[@class='text-xs-center']")
    private WebElement loginHeadline;

    @FindBy(xpath = "//ul[@class='error-messages']/li")
    private WebElement errorMessageContainer;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isLoginPageVisible() {
        waitForVisibility(loginHeadline);
        return loginHeadline.isDisplayed();
    }

    public String getErrorMessageText() {
        waitForVisibility(errorMessageContainer);
        return errorMessageContainer.getText();
    }
}