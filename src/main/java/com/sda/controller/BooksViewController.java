package com.sda.controller;

import com.sda.model.Book;
import com.sda.model.User;
import com.sda.provider.BookFileProvider;
import com.sda.util.DisplayUtil;
import com.sda.view.MainMenuView;
import com.sda.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BooksViewController {
    BookFileProvider bookFileProvider;

    public BooksViewController() {
        bookFileProvider = new BookFileProvider();
    }

    public Map<Integer, String> getBooks() {
        Set<Book> books = bookFileProvider.getAllBooks();
        List<String> authorsAndTitles = new ArrayList<>();

        for (Book book : books) {
            authorsAndTitles.add(book.getAuthor() + ", \"" + book.getTitle() + '\"');
        }

//        List<String> listOfBooks = bookFileProvider.getAllBooks().stream()
//                .map(book -> (book.getAuthor() + "\t\"" + book.getTitle() + '\"'))
//                .collect(Collectors.toList());

        return new DisplayUtil<String>().convertToMap(authorsAndTitles);

    }

    public View returnMainMenu(User loggedUser) {
        return new MainMenuView(loggedUser);
    }
}
