package com.lukasz.ui.steps;

import com.lukasz.ui.pages.HomePage;
import com.lukasz.ui.pages.LoginPage;

public class GoToLoginPageStep extends BaseStep {
    private HomePage homePage;
    private LoginPage loginPage;

    public GoToLoginPageStep(HomePage homePage) {
        this.homePage = homePage;
    }

    @Override
    protected void performAction() {
        loginPage = homePage.goToLoginPage();
    }

}