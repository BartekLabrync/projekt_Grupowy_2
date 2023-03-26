package com.sda.provider;

import com.sda.model.Author;
import com.sda.model.Book;
import com.sda.model.User;
import lombok.Builder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Builder
public class BookFileProvider implements BookProvider {

    private String filePath = "src/main/resources/BooksType";

    public BookFileProvider() {
    }

    public BookFileProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Set<Book> getAllBooks() {

        Set<Book> books = new HashSet<>();
        addAllBooksFromFileToSet(books);
        return books;
    }

    private void addAllBooksFromFileToSet(Set<Book> users) {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                users.add(mapToBook(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Book mapToBook(String bookLine) {
        String[] lineResult = bookLine.split(";");
        return Book.builder()
                .title(lineResult[0])
                .isbn(lineResult[1])
                .author(mapToAuthor(lineResult))
                .publicationDate(mapToPublicationDate(lineResult))
                .build();
    }

    private LocalDate mapToPublicationDate(String[] lineResult) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String date = lineResult[4];

        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

    private Author mapToAuthor(String[] lineResult) {
        return Author.builder()
                .name(lineResult[2])
                .lastName(lineResult[3])
                .build();
    }
    


}


