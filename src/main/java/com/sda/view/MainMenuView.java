package com.sda.view;

import com.sda.controller.MainMenuController;
import com.sda.model.MenuOption;
import com.sda.model.User;

import java.util.*;

public class MainMenuView implements View {
    private final User loggedUser;
    private final MainMenuController mainMenuController;
    private final Scanner scanner;

    public MainMenuView(User loggedUser) {
        this.mainMenuController = new MainMenuController();
        this.loggedUser = loggedUser;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void display() {
        Map<Integer, MenuOption> menuOptions = mainMenuController.getMenuOptions(loggedUser);
        System.out.println("\nMenu:");
        menuOptions.forEach((key, menuOption) -> System.out.println(key + ". " + menuOption.getMessage()));
        mainMenuController.getChoosenView(getData(), loggedUser).display();
    }

    Integer getData() {
        System.out.println();
        System.out.println("podaj cyfre");
        return scanner.nextInt();
    }

}
