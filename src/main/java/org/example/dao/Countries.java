package org.example.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.configuration.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

@Data
@NoArgsConstructor
public class Countries {

    private Long id;
    private String countryName;
    private int population;
    private long area;

    public Countries(String countryName, int population, long area) {
        this.countryName = countryName;
        this.population = population;
        this.area = area;
    }
}
