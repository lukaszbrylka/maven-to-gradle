package com.lukasz.ui.tests;

import com.lukasz.ui.data.UserFactory;
import com.lukasz.ui.models.UserDTO;
import com.lukasz.ui.steps.factory.LoginFlowFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    private UserDTO existingUser;

    @BeforeEach
    void generateUser() {
        existingUser = UserFactory.getExistingUser();
    }

    @Test
    void testExistingUserSuccessfulLogin() {
        LoginFlowFactory
                .successfulLogin(driver, existingUser, existingUser.getUsername())
                .act();
    }

    @Test
    void testExistingUserInvalidPasswordUnsuccessfulLogin() {
        existingUser.
                setPassword("invalid");
        LoginFlowFactory.
                unsuccessfulLogin(driver, existingUser, "Wrong email/password combination")
                .act();
    }
}
