package com.sda.controller;

import com.sda.model.Address;
import com.sda.model.Role;
import com.sda.model.User;
import com.sda.provider.UserFileProvider;
import com.sda.provider.UserProvider;
import com.sda.view.MainMenuView;
import com.sda.view.View;

import java.util.List;

public class AddNewUserController {
    UserProvider userProvider;

    public AddNewUserController() {
        this.userProvider = new UserFileProvider();
    }

    public void addNewUser(String name, String lastName, String email, String login, String password) {
        User newUser = User
                .builder()
                .password(password)
                .name(name)
                .lastName(lastName)
                .email(email)
                .login(login)
                .address(Address.builder().street("ulica").apartmentNo("1").buildingNo("1").postalCode("1").build())
                .roles(List.of(Role.USER))
                .build();
        String line = name + ';' + lastName + ';' + login + ';' + email + ';' + password + ';' + "ulica;1;1;1" + ';' + "USER";
        userProvider.addNewUser(line);
    }
    public View returnMainMenu(User loggedUser) {
        return new MainMenuView(loggedUser);
    }
}
