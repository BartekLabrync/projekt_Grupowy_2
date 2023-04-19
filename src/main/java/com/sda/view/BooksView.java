package com.sda.view;

import com.sda.controller.BooksViewController;
import com.sda.model.User;


import java.util.Map;


public class BooksView implements View {
    private final User loggedUser;
    private final BooksViewController booksViewController;

    public BooksView(User loggedUser) {
        this.loggedUser = loggedUser;
        this.booksViewController = new BooksViewController();
    }

    @Override
    public void display() {
        System.out.println("Books:");
//        Set<Book> books = booksViewController.getBooks();
//        books.forEach(System.out::println);

        Map<Integer, String> books = booksViewController.getBooks();
        books.forEach((key, book) -> System.out.println(key + ". " + book));

        booksViewController.returnMainMenu(loggedUser).display();
    }

}
