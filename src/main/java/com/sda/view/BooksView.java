package com.sda.view;

import com.sda.controller.BooksViewController;


import java.util.Map;


public class BooksView implements View {
    private BooksViewController booksViewController;

    public BooksView() {
        this.booksViewController = new BooksViewController();
    }

    @Override
    public void display() {
        System.out.println("Books:");
//        Set<Book> books = booksViewController.getBooks();
//        books.forEach(System.out::println);

        Map<Integer, String> books = booksViewController.getBooks();
        books.forEach((key, book) -> System.out.println(key + ". " + book));
    }

}
