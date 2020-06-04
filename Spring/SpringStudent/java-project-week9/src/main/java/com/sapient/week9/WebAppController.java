package com.sapient.week9;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebAppController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init() {
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String showStudent(Map<String, Object> model, @RequestParam String id) {
		if (id == "") {
			return "index";
		}
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringBootWebApplication.class);
		
		StudentDAO dao = ctx.getBean(StudentDAO.class);
		Student student = dao.getStudent(Integer.parseInt(id));
		
		model.put("studentID", null);
		model.put("studentName", null);
		model.put("studentCity", null);
		
		if (student != null) {
			model.put("studentID", student.getId());
			model.put("studentName", student.getName());
			model.put("studentCity", student.getCity());
		}
		
		return "student";
	}
}
