package com.sda.view;

import com.sda.controller.AddNewUserController;
import com.sda.model.Address;
import com.sda.model.Role;
import com.sda.model.User;

import java.util.List;
import java.util.Scanner;

public class UserView implements View {
    private final User loggedUser;
    private final AddNewUserController addNewUserController;
    private final Scanner scanner;

    public UserView(User loggedUser){
        this.loggedUser = loggedUser;
        this.addNewUserController = new AddNewUserController();
        scanner = new Scanner(System.in);
    }

    @Override
    public void display() {
        System.out.println("UserView");

        System.out.println("Wprowadź imię:");
        String name = scanner.nextLine();

        System.out.println("Wprowadź nazwisko:");
        String lastName = scanner.nextLine();

        System.out.println("Wprowadź login:");
        String login = scanner.nextLine();

        System.out.println("Wprowadź haslo:");
        String password = scanner.nextLine();

        System.out.println("Wprowadź email:");
        String email = scanner.nextLine();

        addNewUserController.addNewUser(name, lastName, email, login, password);

        addNewUserController.returnMainMenu(loggedUser).display();
    }
}
