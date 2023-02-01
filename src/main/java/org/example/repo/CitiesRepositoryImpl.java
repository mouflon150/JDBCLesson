package org.example.repo;

import org.example.configuration.DatabaseConnection;
import org.example.dao.Cities;
import org.example.dao.People;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitiesRepositoryImpl implements CitiesRepository {

    private Connection connection;

    public CitiesRepositoryImpl() throws SQLException {
        connection = new DatabaseConnection().getConnection();
    }

    @Override
    public void createTable() throws SQLException {
        String queryToCreate = """
                create table if not exists cities
                (
                    id          serial primary key,
                    city_name   varchar not null,
                    inhabitants integer not null
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
        statement.executeUpdate("drop table cities");
        System.out.println("Dropped!");
    }

    @Override
    public void insertInto(Cities city) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("insert into cities(city_name, inhabitants) values (?, ?)");
        preparedStatement.setString(1, city.getCityName());
        preparedStatement.setInt(2, city.getInhabitants());
        preparedStatement.execute();
        preparedStatement.close();
        System.out.println("The city was saved.");
    }

    @Override
    public List<Cities> selectAll() throws SQLException {
        List<Cities> cities = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from cities");
        while (result.next()) {
            Cities city = new Cities();
            city.setId(result.getLong("id"));
            city.setCityName(result.getString("city_name"));
            city.setInhabitants(result.getInt("inhabitants"));
            cities.add(city);
        }
        return cities;
    }

    @Override
    public Cities selectById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from cities where id = " + id + ";");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (!resultSet.next()) {
            System.out.println("There is nothing.");
        }
        Cities city = new Cities();
        city.setId(resultSet.getLong("id"));
        city.setCityName(resultSet.getString("city_name"));
        city.setInhabitants(resultSet.getInt("inhabitants"));
        return city;
    }
}
