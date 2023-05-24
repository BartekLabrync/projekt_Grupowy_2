package com.sda.view;

import com.sda.controller.DataViewController;
import com.sda.model.User;

public class DataView implements View {

    private final User loggedUser;

    private final DataViewController dataViewController;

    public DataView(User loggedUser) {
        this.loggedUser = loggedUser;
        this.dataViewController = new DataViewController();
    }

    @Override
    public void display() {
        System.out.println("Data");
        System.out.println(loggedUser);

        dataViewController.returnMainMenu(loggedUser).display();
    }
}
