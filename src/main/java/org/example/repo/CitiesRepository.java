package org.example.repo;

import org.example.dao.Cities;
import org.example.dao.People;

import java.sql.SQLException;
import java.util.List;

public interface CitiesRepository {

    //create table
    void createTable() throws SQLException;

    //drop table
    void dropTable() throws SQLException;

    //save
    void insertInto(Cities city) throws SQLException;

    //find all
    List<Cities> selectAll() throws SQLException;

    //select by ID
    Cities selectById(Long id) throws SQLException;
}
