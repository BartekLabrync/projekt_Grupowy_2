package com.sda.util;

import com.sda.model.MenuOption;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DisplayUtilTest {

    DisplayUtil displayUtil = new DisplayUtil();

    @Test
    void shouldReturnMapWithAssignedKeyNumbers() {
        //given
        Map<Integer, MenuOption> expectedMap = new HashMap<>();
        expectedMap.put(1, MenuOption.DISPLAY_BOOKS);
        expectedMap.put(2, MenuOption.ADD_NEW_USER);
        expectedMap.put(3, MenuOption.DISPLAY_BOOKS_BY_AUTHOR);
        expectedMap.put(4, MenuOption.DISPLAY_MY_DATA);
        expectedMap.put(5, MenuOption.DISPLAY_USER_DATA);
        List<MenuOption> givenList = new ArrayList<>();
        givenList.add(MenuOption.DISPLAY_BOOKS);
        givenList.add(MenuOption.ADD_NEW_USER);
        givenList.add(MenuOption.DISPLAY_BOOKS_BY_AUTHOR);
        givenList.add(MenuOption.DISPLAY_MY_DATA);
        givenList.add(MenuOption.DISPLAY_USER_DATA);
        //when
        Map<Integer, MenuOption> result = displayUtil.convertToMap(givenList);
        //then
        assertThat(result.entrySet()).containsExactlyElementsOf(expectedMap.entrySet());

    }

    @Data
    @EqualsAndHashCode
    private class ExampleClass{
        private String exampleField;

    }
}