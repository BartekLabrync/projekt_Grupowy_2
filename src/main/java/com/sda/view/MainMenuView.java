package com.sda.view;

import com.sda.controller.MainMenuController;
import com.sda.model.MenuOption;
import com.sda.model.User;

import java.util.*;

public class MainMenuView implements View {
    private User loggedUser;
    private MainMenuController mainMenuController;
    private Scanner scanner;

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
        Integer option = scanner.nextInt();
        return option;
    }

}
