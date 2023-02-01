package org.example.repo;

import org.example.configuration.DatabaseConnection;
import org.example.dao.Countries;
import org.example.dao.People;
import org.example.dao.Presidents;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PresidentRepositoryImpl implements PresidentsRepository {

    private Connection connection;

    public PresidentRepositoryImpl() throws SQLException {
        connection = new DatabaseConnection().getConnection();
    }

    @Override
    public void createTable() throws SQLException {
        String queryToCreate = """
                create table if not exists presidents
                (
                    id          serial primary key,
                    full_name   varchar not null,
                    age         smallint not null,
                    gender      varchar check ( gender = 'Male' or gender = 'Female' )
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
        statement.executeUpdate("drop table presidents");
        System.out.println("Dropped!");
    }

    @Override
    public void insertInto(Presidents president) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("insert into presidents(full_name, age, gender) values (?, ?, ?)");
        preparedStatement.setString(1, president.getFullName());
        preparedStatement.setInt(2, president.getAge());
        preparedStatement.setString(3, president.getGender());
        preparedStatement.execute();
        preparedStatement.close();
        System.out.println("The president was saved.");
    }

    @Override
    public List<Presidents> selectAll() throws SQLException {
        List<Presidents> presidents = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from presidents");
        while (result.next()) {
            Presidents president = new Presidents();
            president.setId(result.getLong("id"));
            president.setFullName(result.getString("full_name"));
            president.setAge((byte) result.getInt("age"));
            president.setGender(result.getString("gender"));
            presidents.add(president);
        }
        return presidents;
    }

    @Override
    public Presidents selectById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from presidents where id = " + id + ";");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (!resultSet.next()) {
            System.out.println("There is nothing.");
        }
        Presidents president = new Presidents();
        president.setId(resultSet.getLong("id"));
        president.setFullName(resultSet.getString("full_name"));
        president.setAge((byte) resultSet.getInt("age"));
        president.setGender(resultSet.getString("gender"));
        return president;
    }
}
