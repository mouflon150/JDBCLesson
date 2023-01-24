package org.example.repo;

import org.example.dao.People;

import java.sql.SQLException;
import java.util.List;

public interface PeopleRepository {

    //create table
    void createTable() throws SQLException;

    //drop table
    void dropTable() throws SQLException;

    //save
    void insertInto(People person) throws SQLException;

    //find all
    List<People> selectAll() throws SQLException;

    //get by id
    People selectById(Long id) throws SQLException;

    //delete by id
    void deleteById(Long id) throws SQLException;

    //clear
    void truncate() throws SQLException;

    //update by id
    void update(Long id, People newPerson) throws SQLException;
}