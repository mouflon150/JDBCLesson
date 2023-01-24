package org.example.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class People {

    private Long id;
    private String name;
    private int age;
    private String gender;

    public People(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}