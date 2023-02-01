package org.example.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Presidents {

    private Long id;
    private String fullName;
    private byte age;
    private String gender;

    public Presidents(String fullName, byte age, String gender) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
    }
}
