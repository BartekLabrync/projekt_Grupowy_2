package com.sda.controller;

import com.sda.UserDataFactory;
import com.sda.model.MenuOption;
import com.sda.model.User;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MainMenuControllerTest {

    MainMenuController mainMenuController = new MainMenuController();

    Map<Integer, MenuOption> expectedMapForUserAdmin = Map.of(
            1, MenuOption.DISPLAY_BOOKS,
            2, MenuOption.ADD_NEW_USER,
            3, MenuOption.DISPLAY_BOOKS_BY_AUTHOR,
            4, MenuOption.DISPLAY_MY_DATA,
            5, MenuOption.DISPLAY_USER_DATA
    );

    @Test
    void shouldDisplayMenuOptionForUserAdmin() {
        //given
        User userWithAllRoles = UserDataFactory.getExampleSingleUserAdmin();
        //when
        Map<Integer, MenuOption> result = mainMenuController.getMenuOptions(userWithAllRoles);
        //then
        assertThat(result.entrySet()).containsExactlyElementsOf(expectedMapForUserAdmin.entrySet());
    }

    Map<Integer, MenuOption> expectedMapForUser = Map.of(
            1, MenuOption.DISPLAY_BOOKS,
            2, MenuOption.DISPLAY_BOOKS_BY_AUTHOR,
            3, MenuOption.DISPLAY_MY_DATA
    );

    @Test
    void shouldDisplayMenuOptionForUser(){
        //given
        User userWithUserOnlyRole = UserDataFactory.getExampleSingleUser();
        //when
        Map<Integer, MenuOption> result = mainMenuController.getMenuOptions(userWithUserOnlyRole);
        //then
        assertThat(result.entrySet()).containsAll(expectedMapForUser.entrySet());
        assertThat(result.size()).isEqualTo(expectedMapForUser.size());
    }

    Map<Integer, MenuOption> expectedMapForAdmin = Map.of(
            1, MenuOption.ADD_NEW_USER,
            2, MenuOption.DISPLAY_USER_DATA
    );

    @Test
    void shouldDisplayMenuOptionForAdmin(){
        //given
        User adminWithAdminOnlyRole = UserDataFactory.getExampleSingleAdmin();

        //when
        Map<Integer, MenuOption> result = mainMenuController.getMenuOptions(adminWithAdminOnlyRole);

        //then
        assertThat(result.entrySet()).containsAll(expectedMapForAdmin.entrySet());
        assertThat(result.size()).isEqualTo(expectedMapForAdmin.size());
    }
}