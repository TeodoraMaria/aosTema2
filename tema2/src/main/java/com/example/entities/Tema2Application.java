package com.example.entities;

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
    
    
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String hello(@RequestParam("name") String name) {
        return "Hello " +name;
    }
    
    @RequestMapping(value="/insert",method=RequestMethod.GET)
    public String insert(@RequestParam("name") String name) {
    	Person person = new Person();
        PersonDAO personDao = new PersonImpl("persistenceUnit");
        person.setName(name);
        person.setEmail("test");
        personDao.insert(person);
        return "Inserted "+person.getName();
    }

}
