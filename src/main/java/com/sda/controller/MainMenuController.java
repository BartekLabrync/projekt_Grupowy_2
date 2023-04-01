package com.sda.controller;

import com.sda.model.MenuOption;
import com.sda.model.User;
import com.sda.service.MenuService;
import com.sda.util.DisplayUtil;
import com.sda.view.*;

import java.util.List;
import java.util.Map;

public class MainMenuController {
    private MenuService menuService;


    public MainMenuController() {
        menuService = new MenuService();
    }

    public Map<Integer, MenuOption> getMenuOptions(User loggedUser) {
        List<MenuOption> menuOptions = menuService.getMenuOptionsForUser(loggedUser);
        return new DisplayUtil<MenuOption>().convertToMap(menuOptions);

    }

    public View getChoosenView(Integer option, User loggedUser) {
        MenuOption selectedOption = getMenuOptions(loggedUser).get(option);
        switch (selectedOption) {
            case ADD_NEW_USER:
                return new UserView();
            case DISPLAY_BOOKS:
                return new BooksView();
            case DISPLAY_MY_DATA:
                return new DataView();
            case DISPLAY_USER_DATA:
                return new UserDataView();
            case DISPLAY_BOOKS_BY_AUTHOR:
                return new AuthorView();
            default:
                return new MainMenuView(loggedUser);
        }

    }

}
