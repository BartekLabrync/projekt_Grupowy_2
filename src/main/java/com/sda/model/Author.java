package com.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private String name;
    private String lastName;

    @Override
    public String toString() {
        return name + " " + lastName;
    }
}
