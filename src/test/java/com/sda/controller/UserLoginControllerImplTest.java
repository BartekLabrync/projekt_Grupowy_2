package com.sda.controller;

import com.sda.api.UserLoginData;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginControllerImplTest {

    private static final UserLoginData CORRECT_USER_LOGIN_DATA = new UserLoginData("correctLogin", "correctPassword");
    private static final UserLoginData INCORRECT_USER_LOGIN_DATA = new UserLoginData("incorrectLogin", "incorrectPassword");

    private UserLoginControllerImpl userLoginController = new UserLoginControllerImpl(
        userLoginData -> {
            if (userLoginData.equals(CORRECT_USER_LOGIN_DATA)) {
                Optional.of(new U)
            }
        }
    )

    void

}