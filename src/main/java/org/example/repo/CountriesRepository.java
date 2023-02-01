package org.example.repo;

import org.example.dao.Cities;
import org.example.dao.Countries;
import org.example.dao.People;

import java.sql.SQLException;
import java.util.List;

public interface CountriesRepository {

    //create table
    void createTable() throws SQLException;

    //drop table
    void dropTable() throws SQLException;

    //save
    void insertInto(Countries country) throws SQLException;

    //find all
    List<Countries> selectAll() throws SQLException;

    //select by ID
    Countries selectById(Long id) throws SQLException;
}
