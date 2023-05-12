package com.sda.controller;

import com.sda.model.User;
import com.sda.view.MainMenuView;
import com.sda.view.View;

public class DataViewController {

    public View returnMainMenu(User loggedUser) {
        return new MainMenuView(loggedUser);
    }

}
