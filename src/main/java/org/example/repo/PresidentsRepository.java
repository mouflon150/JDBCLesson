package org.example.repo;

import org.example.dao.People;
import org.example.dao.Presidents;

import java.sql.SQLException;
import java.util.List;

public interface PresidentsRepository {

    //create table
    void createTable() throws SQLException;

    //drop table
    void dropTable() throws SQLException;

    //save
    void insertInto(Presidents president) throws SQLException;

    //find all
    List<Presidents> selectAll() throws SQLException;

    //select by ID
    Presidents selectById(Long id) throws SQLException;
}
