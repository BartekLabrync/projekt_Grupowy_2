package com.sda.controller;

import com.sda.api.UserLoginData;
import com.sda.view.LoginView;
import com.sda.view.MainMenuView;
import com.sda.view.View;

public class UserLoginControllerImpl implements UserLoginController {

    @Override
    public View login(UserLoginData userLoginData) {
        //użtykownik zalogował się pomyślnie
        if (true) {
            return new MainMenuView();
        }
        return new LoginView();
    }

}
