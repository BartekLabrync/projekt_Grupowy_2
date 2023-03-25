package com.sda.view;

import com.sda.api.UserLoginData;
import com.sda.controller.UserLoginController;

import java.util.Scanner;

public class LoginView implements View {

    private Scanner scanner;
    private UserLoginController userLoginController;


    @Override
    public void display() {
        userLoginController.login(getData()).display();
    }

    private UserLoginData getData() {

        return null;
    }

}
