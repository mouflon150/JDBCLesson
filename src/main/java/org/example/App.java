package org.example;

import org.example.repo.CitiesRepositoryImpl;
import org.example.repo.CountriesRepositoryImpl;
import org.example.repo.PeopleRepositoryImpl;
import org.example.repo.PresidentRepositoryImpl;

public class App {

    public static void main(String[] args) throws Exception {

        PeopleRepositoryImpl persons = new PeopleRepositoryImpl();
        CitiesRepositoryImpl citiesRepository = new CitiesRepositoryImpl();
        CountriesRepositoryImpl countriesRepository = new CountriesRepositoryImpl();
        PresidentRepositoryImpl presidentRepository = new PresidentRepositoryImpl();

//        citiesRepository.createTable();
//        countriesRepository.createTable();
//        presidentRepository.createTable();

//        citiesRepository.insertInto(new Cities("Moscow", 12000000));
//        citiesRepository.insertInto(new Cities("Bishkek", 1088000));
//        citiesRepository.insertInto(new Cities("Pekin", 21705000));
//        citiesRepository.insertInto(new Cities("Istanbul", 15462000));
//        citiesRepository.insertInto(new Cities("Tashkent", 2694378));

//        countriesRepository.insertInto(new Countries("Russia", 146980061, 17125191));
//        countriesRepository.insertInto(new Countries("Kyrgyzstan", 6256700, 199951));
//        countriesRepository.insertInto(new Countries("China", 1410539758, 9596961));
//        countriesRepository.insertInto(new Countries("Turkey", 84680273, 783356));
//        countriesRepository.insertInto(new Countries("Uzbekistan", 36001262, 448978));

//        presidentRepository.insertInto(new Presidents("Vladimir Putin", (byte) 50, "Male"));
//        presidentRepository.insertInto(new Presidents("Sadyr Japarov", (byte) 42, "Male"));
//        presidentRepository.insertInto(new Presidents("Xi Jinping", (byte) 70, "Male"));
//        presidentRepository.insertInto(new Presidents("Recep Tayyin Erdogan", (byte) 68, "Male"));
//        presidentRepository.insertInto(new Presidents("Shavkat Mirziyoyev", (byte) 65, "Male"));

//        citiesRepository.selectAll().forEach(System.out::println);
//        countriesRepository.selectAll().forEach(System.out::println);

        System.out.println(citiesRepository.selectById(1L));
    }
}