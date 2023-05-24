package com.sda.view;

import com.sda.controller.AuthorViewController;
import com.sda.model.User;

import java.util.Map;
import java.util.Scanner;

public class AuthorView implements View {
    private final User loggedUser;
    private final AuthorViewController authorViewController;
    private final Scanner scanner;

    public AuthorView(User loggedUser) {
        this.loggedUser = loggedUser;
        this.authorViewController = new AuthorViewController();
        scanner = new Scanner(System.in);
    }

    @Override
    public void display() {
        System.out.println("Podaj nazwisko autora: ");
        String authorName = scanner.nextLine();
        System.out.println("Books:");

        Map<Integer, String> books = authorViewController.getAuthorBooks(authorName);
        books.forEach((key, book) -> System.out.println(key + ". " + book));

        authorViewController.returnMainMenu(loggedUser).display();
    }
}
