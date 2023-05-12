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
import java.util.stream.Collectors;

public class AuthorViewController {
    private final BookFileProvider bookFileProvider;

    public AuthorViewController() {
        this.bookFileProvider = new BookFileProvider();
    }

    public Map<Integer, String> getAuthorBooks(String authorName) {
        Set<Book> books = bookFileProvider.getAllBooks();
        List<String> authorsAndTitles = new ArrayList<>();

        books = books.stream().filter(book -> book.getAuthor().getLastName().equals(authorName)).collect(Collectors.toSet());

        for (Book book : books) {
            authorsAndTitles.add(book.getAuthor() + ", \"" + book.getTitle() + '\"');
        }

        return new DisplayUtil<String>().convertToMap(authorsAndTitles);

    }

    public View returnMainMenu(User loggedUser) {
        return new MainMenuView(loggedUser);
    }
}
