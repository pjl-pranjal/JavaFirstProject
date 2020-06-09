package com.sapient.week10;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class WebAppController {
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value = "/emp")
	public List<Employee> getAll() {
		return this.empService.getAll();
	}
	
	@RequestMapping(value = "/emp/insert", method = RequestMethod.POST)
	public String insert(ModelMap map, @RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("city") String city) {
		this.empService.insert(new Employee(id, name, city));
		return "success";
	}
	
	@RequestMapping(value = "/emp/delete/{id}")
	public String delete(ModelMap map, @PathVariable("id") String id) {
		this.empService.delete(id);
		return "success";
	}
	
	@RequestMapping(value = "/emp/{id}")
	public Employee getByID(ModelMap map, @PathVariable("id") String id) {
		return this.empService.getByID(id);
	}
	
	@RequestMapping(value = "/emp/name/{name}")
	public Employee getByName(ModelMap map, @PathVariable("name") String name) {
		return this.empService.getByName(name);
	}
}
