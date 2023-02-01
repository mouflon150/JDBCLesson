package org.example.repo;

import org.example.configuration.DatabaseConnection;
import org.example.dao.Cities;
import org.example.dao.Countries;
import org.example.dao.People;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountriesRepositoryImpl implements CountriesRepository {

    private Connection connection;

    public CountriesRepositoryImpl() throws SQLException {
        connection = new DatabaseConnection().getConnection();
    }

    @Override
    public void createTable() throws SQLException {
        String queryToCreate = """
                create table if not exists countries
                (
                    id           serial primary key,
                    country_name varchar not null,
                    population   integer not null,
                    area         integer not null
                );
                """;
        Statement statement = connection.createStatement();
        statement.execute(queryToCreate);
        statement.close();
        System.out.println("The table was successfully created.");
    }

    @Override
    public void dropTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("drop table countries");
        System.out.println("Dropped!");
    }

    @Override
    public void insertInto(Countries country) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("insert into countries(country_name, population, area) values (?, ?, ?)");
        preparedStatement.setString(1, country.getCountryName());
        preparedStatement.setInt(2, country.getPopulation());
        preparedStatement.setLong(3, country.getArea());
        preparedStatement.execute();
        preparedStatement.close();
        System.out.println("The country was saved.");
    }

    @Override
    public List<Countries> selectAll() throws SQLException {
        List<Countries> countries = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from countries");
        while (result.next()) {
            Countries country = new Countries();
            country.setId(result.getLong("id"));
            country.setCountryName(result.getString("country_name"));
            country.setPopulation(result.getInt("population"));
            country.setArea(result.getLong("area"));
            countries.add(country);
        }
        return countries;
    }

    @Override
    public Countries selectById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from countries where id = " + id + ";");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (!resultSet.next()) {
            System.out.println("There is nothing.");
        }
        Countries country = new Countries();
        country.setId(resultSet.getLong("id"));
        country.setCountryName(resultSet.getString("country_name"));
        country.setPopulation(resultSet.getInt("population"));
        country.setArea(resultSet.getLong("area"));
        return country;
    }
}
