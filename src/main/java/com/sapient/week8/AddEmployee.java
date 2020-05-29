package com.sapient.week8;

import java.util.ArrayList;
import java.util.List;

public class AddEmployee 
{
    List<Employee> list = new ArrayList<Employee>();

    public void addEmployee(Employee emp) {
        if (this.getEmployee(emp.getId()) != null) return;
        this.list.add(emp);
    }

    public Employee getEmployee(int id) {
        for (Employee employee : this.list) {
            if (employee.getId() == id) return employee;
        }
        return null;
    }
}
