package com.lukasz.ui.data;

import com.lukasz.ui.models.UserDTO;
import com.lukasz.ui.utils.UserBuilder;

public class UserFactory {
    private static final String DOMAIN = "@slytherin.com";
    private static final String USERNAME_BASE = "RandomRiddle";
    private static final String EXISTING_USERNAME = "TomRiddle1926";
    private static final String PASSWORD = "albusIsOld123";

    public static UserDTO getExistingUser() {
        return new UserBuilder()
                .withUsername(EXISTING_USERNAME)
                .withEmail(EXISTING_USERNAME.toLowerCase() + DOMAIN)
                .withPassword(PASSWORD)
                .build();
    }
}