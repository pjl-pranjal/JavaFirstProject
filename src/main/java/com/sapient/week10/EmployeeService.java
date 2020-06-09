package com.sapient.week10;

import java.util.Map;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeService {
	private Map<String, Employee> empMap = new HashMap<String, Employee>();
	
	// insert and modify
	public void insert(Employee emp) {
		this.empMap.put(emp.getId(), emp);
	}
	
	public void delete(String id) {
		this.empMap.remove(id);
	}
	
	public List<Employee> getAll() {
		return new ArrayList<Employee>(this.empMap.values());
	}
	
	public Employee getByID(String id) {
		return this.empMap.get(id);
	}
	
	public Employee getByName(String name) {
		for (Employee emp : this.empMap.values()) {
			if (emp.getName().equals(name))
				return emp;
		}
		
		return null;
	}
}
