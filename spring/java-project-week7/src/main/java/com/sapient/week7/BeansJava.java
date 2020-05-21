package com.sapient.week7;

import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;


@Configuration
public class BeansJava {
	
	@Bean
	public EmpMap emap() {
		Map<Integer, Employee> map = new HashMap<Integer, Employee>();
		map.put(1, e1());
		map.put(2, e2());
		
		EmpMap emap = new EmpMap();
		emap.setMap(map);
		return emap;
	}
	
	@Bean
	public Employee e1() {
		return new Employee(1, "Name1", "City1");
	}
	
	@Bean
	public Employee e2() {
		return new Employee(2, "Name2", "City2");
	}
}
