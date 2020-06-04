package com.sapient.week9;

import java.util.Map;
import java.util.HashMap;

public class StudentDAO {
	private Map<Integer, Student> studentMap = new HashMap<Integer, Student>();
	
	public void addStudent(Student student) {
		if (!this.studentMap.containsKey(student.getId())) {
			this.studentMap.put(student.getId(), student);
		}
	}
	
	public Student getStudent(int id) {
		return this.studentMap.get(id);
	}
}
