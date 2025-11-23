package com.lukasz.ui.steps.factory;

import com.lukasz.ui.models.UserDTO;
import com.lukasz.ui.pages.HomePage;
import com.lukasz.ui.pages.LoginPage;

import com.lukasz.ui.steps.GoToLoginPageStep;
import com.lukasz.ui.steps.SubmitLoginStep;
import com.lukasz.ui.steps.VerifyErrorMessageStep;
import com.lukasz.ui.steps.VerifyUserIsLoggedInStep;
import org.openqa.selenium.WebDriver;

public class LoginFlowFactory {

    public static GoToLoginPageStep successfulLogin(WebDriver driver, UserDTO user, String expectedUsername) {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        GoToLoginPageStep goToLogin = new GoToLoginPageStep(homePage);
        SubmitLoginStep submitLogin = new SubmitLoginStep(loginPage, user);
        VerifyUserIsLoggedInStep verifyLogin = new VerifyUserIsLoggedInStep(new HomePage(driver), expectedUsername);

        goToLogin.then(submitLogin).then(verifyLogin);
        return goToLogin;
    }

    public static GoToLoginPageStep unsuccessfulLogin(WebDriver driver, UserDTO user, String expectedErrorMessage) {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        GoToLoginPageStep goToLogin = new GoToLoginPageStep(homePage);
        SubmitLoginStep submitLogin = new SubmitLoginStep(loginPage, user);
        VerifyErrorMessageStep verifyError = new VerifyErrorMessageStep(loginPage, expectedErrorMessage);

        goToLogin.then(submitLogin).then(verifyError);
        return goToLogin;
    }
}