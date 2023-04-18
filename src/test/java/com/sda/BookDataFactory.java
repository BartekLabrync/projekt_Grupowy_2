package com.sda;

import com.sda.model.Author;
import com.sda.model.Book;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class BookDataFactory {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    private static final Book BOOK1 = new Book(
            "Krzyzacy",
            "1243",
            new Author(
                    "Henryk",
                    "Sienkiewicz"),
            LocalDate.parse("1/01/1900", formatter)
    );
    private static final Book BOOK2 = new Book(
            "Test",
            "1111",
            new Author(
                    "TEST",
                    "TESTOwanie"),
            LocalDate.parse("1/01/1910", formatter)
    );
    private static final Set<Book> EXAMPLE_BOOK_DATA = Set.of(
            BOOK1,
            BOOK2
    );

    public static Set<Book> getExampleBookData() {
        return EXAMPLE_BOOK_DATA;
    }
}

