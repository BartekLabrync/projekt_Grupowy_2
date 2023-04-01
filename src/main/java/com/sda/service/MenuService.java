package com.sda.service;

import com.sda.model.MenuOption;
import com.sda.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MenuService {

    public List<MenuOption> getMenuOptionsForUser(User loggedUser){
        return Arrays.stream(MenuOption.values())
                .filter(menuOption -> loggedUser.getRoles().contains(menuOption.getNecessaryRole()))
                .collect(Collectors.toList());
    }
}
