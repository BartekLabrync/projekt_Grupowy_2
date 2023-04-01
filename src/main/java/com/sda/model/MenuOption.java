package com.sda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MenuOption {
    DISPLAY_BOOKS("Wyswietl ksiazki", Role.USER),
    ADD_NEW_USER("Dodaj nowego uzytkownika", Role.ADMIN),
    DISPLAY_BOOKS_BY_AUTHOR("Wyswietl ksiazki danego autora", Role.USER),
    DISPLAY_MY_DATA("Wyswietl moje dane", Role.USER),
    DISPLAY_USER_DATA("Wyswietl dane wybranego uzytkownika", Role.ADMIN);


    private String message;
    private Role necessaryRole;

}
