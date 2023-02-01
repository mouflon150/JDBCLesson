package org.example.repo;

import org.example.configuration.DatabaseConnection;
import org.example.dao.People;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeopleRepositoryImpl implements PeopleRepository {

    private final Connection connection;

    public PeopleRepositoryImpl() throws Exception {
        connection = new DatabaseConnection().getConnection();
    }

    @Override
    public void createTable() throws SQLException {
        String queryToCreate = """
                create table if not exists people
                (
                    id      serial primary key,
                    name    varchar(55) not null,
                    age     smallint default 18,
                    gender  varchar check ( gender = 'Male' or gender = 'Female' )
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
        statement.executeUpdate("drop table people");
        System.out.println("Dropped!");
    }

    @Override
    public void insertInto(People person) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("insert into people(name, age, gender) values (?, ?, ?)");
        preparedStatement.setString(1, person.getName());
        preparedStatement.setInt(2, person.getAge());
        preparedStatement.setString(3, person.getGender());
        preparedStatement.execute();
        preparedStatement.close();
        System.out.println("The person was saved.");
    }

    @Override
    public List<People> selectAll() throws SQLException {
        List<People> allPeople = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from people");
        while (result.next()) {
            People person = new People();
            person.setId(result.getLong("id"));
            person.setName(result.getString("name"));
            person.setAge(result.getInt("age"));
            person.setGender(result.getString("gender"));
            allPeople.add(person);
        }
        return allPeople;
    }

    @Override
    public People selectById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from people where id = " + id + ";");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (!resultSet.next()) {
            System.out.println("There is nothing.");
        }
        People person = new People();
        person.setId(resultSet.getLong("id"));
        person.setName(resultSet.getString("name"));
        person.setAge(resultSet.getInt("age"));
        person.setGender(resultSet.getString("gender"));
        return person;
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from people where id = " + id + ";");
        preparedStatement.executeUpdate();
        System.out.println("Person under index " + id + " was successfully removed.");
    }

    @Override
    public void truncate() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("truncate table people");
        System.out.println("Cleared!");
    }

    @Override
    public void update(Long id, People newPerson) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update people set name = ?, age = ?, gender = ? where id = " + id + ";");
        preparedStatement.setString(1, newPerson.getName());
        preparedStatement.setInt(2, newPerson.getAge());
        preparedStatement.setString(3, newPerson.getGender());
        preparedStatement.executeUpdate();
        System.out.println("Data has been successfully updated.");
    }
}
