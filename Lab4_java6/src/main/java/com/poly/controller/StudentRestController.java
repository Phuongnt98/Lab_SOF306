package com.poly.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.poly.dao.StudentDAO;
import com.poly.model.Student;
import com.poly.model.StudentMap;

@Controller
//@RequestMapping("/rest-api/student")
public class StudentRestController {
	
	@Autowired
	StudentDAO dao;
	
	@RequestMapping("/student/index")
	public String index(Model model) {
		Student student = new Student("", "",0.0, true, "VN");
		model.addAttribute("form", student);
		StudentMap map = dao.fillAll();
		model.addAttribute("items", map);
		return "student/index";
	}
	
	@RequestMapping("/student/edit/{key}")
	public String edit(Model model, @PathVariable("key") String key) {
		model.addAttribute("key", key);
		Student student = dao.findByKey(key);
		model.addAttribute("form", student);
		StudentMap map = dao.fillAll();
		model.addAttribute("items", map);
		return "student/index";
	}
	
	@RequestMapping("/student/create")
	public String create(Student student) {
		dao.create(student);
		return "redirect:/student/index";
	}
	
	@RequestMapping("/student/update/{key}")
	public String update( @PathVariable("key") String key, Student student) {
		dao.update(key, student);
		return "redirect:/student/edit/" +key;
	}
	
	@RequestMapping("/student/delete/{key}")
	public String delete( @PathVariable("key") String key) {
		dao.delete(key);
		return "redirect:/student/index";
	}
	
	
//	@GetMapping
//	public StudentMap getAll(){
//		return dao.fillAll();
//	}
//	
//	@PostMapping
//	public String post(@RequestBody Student student) {
//		return dao.create(student);
//	}
//	
//	@PutMapping
//	public String update()
}
