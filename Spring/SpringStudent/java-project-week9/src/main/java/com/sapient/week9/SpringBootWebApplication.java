package com.sapient.week9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@SpringBootApplication
public class SpringBootWebApplication {
	public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
	
	@Bean
	public StudentDAO studentDAOSetter() {
		StudentDAO dao = new StudentDAO();
		
		dao.addStudent(getStudent(1, "Name1", "City1"));
		dao.addStudent(getStudent(2, "Name2", "City2"));
		dao.addStudent(getStudent(3, "Name3", "City3"));
		
		return dao;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Student getStudent(int id, String name, String city) {
		return new Student(id, name, city);
	}
}