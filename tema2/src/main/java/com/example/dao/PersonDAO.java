package com.example.dao;

import java.util.ArrayList;

import com.example.entities.Person;





public interface PersonDAO {
	public void insert(Person person);
	public ArrayList<Person> getAll();
	public Person findPerson(Person person);
	public void delete(Person person);
}
