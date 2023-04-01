package com.sda.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayUtil<T>{
    public Map<Integer, T> convertToMap(List<T> list){
        Map<Integer, T> result = new HashMap<>();
        for (int i = 1; i <= list.size(); i++) {
            result.put(i, list.get(i - 1));
        }
        return result;
    }
}
