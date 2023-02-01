package org.example.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.configuration.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

@Data
@NoArgsConstructor
public class Cities {

    private Long id;
    private String cityName;
    private int inhabitants;

    public Cities(String cityName, int inhabitants) {
        this.cityName = cityName;
        this.inhabitants = inhabitants;
    }
}