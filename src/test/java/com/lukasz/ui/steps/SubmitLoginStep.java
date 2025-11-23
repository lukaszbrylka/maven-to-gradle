package com.lukasz.ui.steps;

import com.lukasz.ui.models.UserDTO;
import com.lukasz.ui.pages.LoginPage;

public class SubmitLoginStep extends BaseStep {
    private final LoginPage loginPage;
    private final UserDTO user;

    public SubmitLoginStep(LoginPage loginPage, UserDTO user) {
        this.loginPage = loginPage;
        this.user = user;
    }

    @Override
    protected void performAction() {
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickLogin();
    }
}