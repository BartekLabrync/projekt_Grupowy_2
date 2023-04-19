package com.sda.provider;

import com.sda.model.Book;

import java.util.Set;

public interface BookProvider {
    Set<Book> getAllBooks();
}
