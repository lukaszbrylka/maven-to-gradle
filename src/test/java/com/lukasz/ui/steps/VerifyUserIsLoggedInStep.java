package com.lukasz.ui.steps;

import com.lukasz.ui.pages.HomePage;

public class VerifyUserIsLoggedInStep extends BaseStep {
    private final HomePage homePage;
    private final String expectedUsername;

    public VerifyUserIsLoggedInStep(HomePage homePage, String expectedUsername) {
        this.homePage = homePage;
        this.expectedUsername = expectedUsername;
    }

    @Override
    protected void performAction() {
        if (!homePage.isUserLoggedIn()) {
            throw new AssertionError("User should be logged in");
        }
        if (!expectedUsername.equals(homePage.getUserNameFromNavBar())) {
            throw new AssertionError("Username in navbar should match expected");
        }
    }
}
