package com.lukasz.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {


    @FindBy(xpath = "//li/a[@href='#/']")
    private WebElement homeNavBarButton;

    @FindBy(xpath = "//li/a[@href='#/register']")
    private WebElement signUpNavBarButton;

    @FindBy(xpath = "//li/a[@href='#/login']")
    private WebElement loginNavBarButton;

    @FindBy(xpath = "//div[@class='home-page']/div[@class='banner']")
    private WebElement homePageBanner;

    @FindBy(xpath = "//li/div[./img[@class='user-pic']]")
    private WebElement userAvatar;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage clickHomeNavBar() {
        homeNavBarButton.click();
        return this;
    }

    public LoginPage goToLoginPage() {
        loginNavBarButton.click();
        return new LoginPage(driver);
    }

    public boolean isUserLoggedIn() {
        waitForVisibility(userAvatar);
        return userAvatar.isDisplayed();
    }

    public boolean isUserLoggedOut() {
        waitForVisibility(homePageBanner);
        return homePageBanner.isDisplayed();
    }

    public String getUserNameFromNavBar() {
        return userAvatar.getText().trim();
    }
}