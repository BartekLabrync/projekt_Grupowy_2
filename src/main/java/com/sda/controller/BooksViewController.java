package com.sda.controller;

import com.sda.model.Book;
import com.sda.provider.BookFileProvider;

import java.util.Set;

public class BooksViewController {
    BookFileProvider bookFileProvider;

    public BooksViewController() {
        bookFileProvider = new BookFileProvider();
    }

    public Set<Book> getBooks() {
        return bookFileProvider.getAllBooks();
    }
}
