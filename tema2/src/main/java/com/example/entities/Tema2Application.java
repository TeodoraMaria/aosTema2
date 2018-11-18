package com.example.entities;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.PersonDAO;
import com.example.dao.PersonImpl;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class Tema2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tema2Application.class, args);
	}

	@RequestMapping("/")
	public String greeting() {
		return "Greetings from Gradle Spring Boot Application!";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(@RequestParam("name") String name) {
		return "Hello " + name;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@RequestParam("name") String name, @RequestParam("email") String email) {
		Person person = new Person();
		PersonImpl accountBl = new PersonImpl("persistenceUnit");
		person.setName(name);
		person.setEmail(email);
		accountBl.insert(person);
		return "Inserted ";
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public String getAll() {
		PersonImpl accountBl = new PersonImpl("persistenceUnit");
		ArrayList<Person> people = accountBl.getAll();
		return people.toString();
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam("oldName") String oldName, @RequestParam("oldEmail") String oldEmail,
			@RequestParam("name") String name, @RequestParam("email") String email) {
		PersonImpl accountBl = new PersonImpl("persistenceUnit");
		Person person = new Person(oldName, oldEmail);
		Person newPerson = new Person(name, email);
		accountBl.update(person, newPerson);
		return "Updated";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("name") String name, @RequestParam("email") String email) {
		PersonImpl accountBl = new PersonImpl("persistenceUnit");
		Person person = new Person(name, email);
		accountBl.delete(person);
		return "Deleted";
	}

}
