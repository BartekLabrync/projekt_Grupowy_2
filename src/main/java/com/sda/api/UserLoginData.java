package com.sda.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginData {

    private final String login;
    private final String password;

}
