package com.test.demo.mockito;

public interface PersonDao {

    Person getPerson(int id);

    boolean update(Person person);
}