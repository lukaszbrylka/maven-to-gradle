package com.lukasz.ui.steps;

import com.lukasz.ui.pages.LoginPage;


public class VerifyErrorMessageStep extends BaseStep {
    private final LoginPage loginPage;
    private final String expectedMessage;

    public VerifyErrorMessageStep(LoginPage loginPage, String expectedMessage) {
        this.loginPage = loginPage;
        this.expectedMessage = expectedMessage;
    }

    @Override
    protected void performAction() {
        String actualMessage = loginPage.getErrorMessageText().trim();
        if (!expectedMessage.equals(actualMessage)) {
            throw new AssertionError("Expected error message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }
}