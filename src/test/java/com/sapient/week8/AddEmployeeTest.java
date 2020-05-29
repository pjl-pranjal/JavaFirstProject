package com.sapient.week8;

import org.junit.Test;
import static org.junit.Assert.*;

public class AddEmployeeTest
{
    private AddEmployee empAdder = new AddEmployee();

    @Test
    public void test1() {
        assertEquals(0, empAdder.list.size());

        empAdder.addEmployee(new Employee(1, "Name1", "City1"));
        assertEquals(1, empAdder.list.size());

        empAdder.addEmployee(new Employee(2, "Name2", "City2"));
        empAdder.addEmployee(new Employee(3, "Name3", "City3"));
        assertEquals(3, empAdder.list.size());

        // ID 1 already exists, shouldn't be added
        empAdder.addEmployee(new Employee(1, "Name4", "City4"));
        assertEquals(3, empAdder.list.size());
    }
}
