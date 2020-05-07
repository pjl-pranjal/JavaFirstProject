package com.sapient.week5;

import java.util.Collections;

public class BO {
	public void read() {
		System.out.println("Enter id, name, city:");
		
		// Scanner reader = new Scanner(System.in);
		int id = Integer.parseInt(Reader.read.nextLine());
		String name = Reader.read.nextLine();
		String city = Reader.read.nextLine();
		// reader.close();

		Student student = new Student(id, name, city);
		StudentData.data.add(student);
	}

	public void display(Student student) {
		System.out.println(student.toString());
	}

	public void display(int id) {
		for (Student student : StudentData.data) {
			if (student.getId() == id) {
				System.out.println(student.toString());
				return;
			}
		}
		System.out.println("Unable to locate student with id: " + id);
		return;
		// throw new ObjectNotFoundException("Unable to locate student with id: " + id);
	}

	public void display() {
		for (Student student : StudentData.data) {
			System.out.println(student.toString());
		}
	}

	public void displayForCity(String city) {
		for (Student student : StudentData.data) {
			if (student.getCity().equals(city))
				System.out.println(student.toString());
		}
	}

	public void displaySorted(Boolean city) {
		if (city)
			Collections.sort(StudentData.data, (a, b) -> {return a.getCity().compareTo(b.getCity());});
		else
			Collections.sort(StudentData.data, (a, b) -> {return a.getName().compareTo(b.getName());});

		this.display();
	}
}
