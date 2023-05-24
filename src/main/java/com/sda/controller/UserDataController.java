package com.sda.controller;

import com.sda.model.User;
import com.sda.provider.UserFileProvider;
import com.sda.provider.UserProvider;
import com.sda.view.MainMenuView;
import com.sda.view.View;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDataController {
    private final UserProvider userProvider;

    public Set<String> getAllUserLogins() {
        Set<User> users = userProvider.getAllUsers();
        Set<String> userLogins = users
                .stream()
                .map(User::getLogin)
                .collect(Collectors.toSet());
        return userLogins;
    }

    public Optional<User> getUser(String login){
        return userProvider.getAllUsers().stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst();
    }

    public UserDataController() {
        this.userProvider = new UserFileProvider();
    }

    public View returnMainMenu(User loggedUser) {
        return new MainMenuView(loggedUser);
    }
}
