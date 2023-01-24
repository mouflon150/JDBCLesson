package org.example;

import org.example.dao.People;
import org.example.repo.PeopleImpl;

public class App {

    public static void main(String[] args) throws Exception {

        PeopleImpl persons = new PeopleImpl();
//        persons.createTable();
//        persons.dropTable();
//        persons.insertInto(new People("Juliet", 25, "Female"));
//        persons.truncate();
//        persons.update(0L, new People("Marlen", 17, "Male"));
//        System.out.println(persons.selectById(7L));
        persons.selectAll().forEach(System.out::println);
    }
}
