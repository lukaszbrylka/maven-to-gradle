package com.lukasz.ui.utils;

import com.lukasz.ui.models.UserDTO;

public class UserBuilder {
    private String email;
    private String password;
    private String username;

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserDTO build() {
        UserDTO user = new UserDTO();

        if (email == null || password == null || username == null) {
            throw new IllegalStateException("All fields must be set");
        }
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);
        return user;
    }
}