package com.sda.view;

import com.sda.controller.UserDataController;
import com.sda.model.Role;
import com.sda.model.User;

import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class UserDataView implements View {

    private final UserDataController userDataController;
    private final Scanner scanner;
    private final User loggedUser;

    public UserDataView(User loggedUser) {
        this.loggedUser = loggedUser;
        this.userDataController = new UserDataController();
        scanner = new Scanner(System.in);
    }


    @Override
    public void display() {
        if(!isAdmin()){
            userDataController.returnMainMenu(loggedUser).display();
        }

        System.out.println("Użytkownicy: ");
        Set<String> logins = userDataController.getAllUserLogins();
        logins.forEach(System.out::println);

        System.out.println("Podaj dane Użytkownia: ");
        String userLogin = scanner.nextLine();

        //User user = userDataController.getUser(userLogin).get();
        //System.out.println(user);
        Optional<User> user = userDataController.getUser(userLogin);
        if (user.isPresent()) {
            System.out.println(user.get());
        } else {
            System.out.println("Użytkownik nie istnieje.");
        }

        userDataController.returnMainMenu(loggedUser).display();

    }

    public boolean isAdmin(){
        if(loggedUser.getRoles().contains(Role.ADMIN))
            return true;
        return false;
    }
}
